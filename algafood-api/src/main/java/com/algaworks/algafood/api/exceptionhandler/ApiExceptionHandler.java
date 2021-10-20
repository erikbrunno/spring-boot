package com.algaworks.algafood.api.exceptionhandler;

import java.nio.file.AccessDeniedException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algafood.core.validation.ValidacaoException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	public static final String MSG_ERRO_SISTEMA = "Ocorreu um erro interno inesperado no sistema. "
            + "Tente novamente e se o problema persistir, entre em contato "
            + "com o administrador do sistema.";
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		return handleValidationInternal(ex, ex.getBindingResult(), headers, status, request);
	}
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException e,
			WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		var problemType = ProblemType.RECURSO_NAO_ENCONTRADO;
		var problem = createProblemBuilder(status, problemType, e.getMessage())
				.userMessage(e.getMessage())
				.build();

		return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleNegocio(NegocioException e, WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		var problemType = ProblemType.ERRO_NEGOCIO;
		var problem = createProblemBuilder(status, problemType, e.getMessage())
				.userMessage(e.getMessage())
				.build();

		return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<?> handleAcessoNegado(AccessDeniedException ex, WebRequest request) {

	    HttpStatus status = HttpStatus.FORBIDDEN;
	    ProblemType problemType = ProblemType.ACESSO_NEGADO;
	    String detail = ex.getMessage();

	    Problem problem = createProblemBuilder(status, problemType, detail)
	            .userMessage(detail)
	            .userMessage("Você não possui permissão para executar essa operação.")
	            .build();

	    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleUncaught(Exception e,
			WebRequest request) {

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		var problemType = ProblemType.ERRO_DE_SISTEMA;
		
	    // Importante colocar o printStackTrace (pelo menos por enquanto, que não estamos
	    // fazendo logging) para mostrar a stacktrace no console
		log.error(e.getMessage(), e);
	    
	    var problem = createProblemBuilder(status, problemType, MSG_ERRO_SISTEMA)
	    		.userMessage(MSG_ERRO_SISTEMA)
	    		.build();

		return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<?> handleEntidadeEmUso(EntidadeEmUsoException e, WebRequest request) {

		HttpStatus status = HttpStatus.CONFLICT;
		var problemType = ProblemType.ENTIDADE_EM_USO;
		var problem = createProblemBuilder(status, problemType, e.getMessage())
				.userMessage(e.getMessage())
				.build();

		return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity<Object> handleValidacaoException(ValidacaoException  e, WebRequest request) {
		HttpStatus status  = HttpStatus.BAD_REQUEST;
		
		return handleValidationInternal(e, e.getBindingResult(), new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return ResponseEntity.status(status).headers(headers).build();
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		if (body == null) {
			body = Problem.builder().title(status.getReasonPhrase()).status(status.value())
					.userMessage(MSG_ERRO_SISTEMA)
					.build();
		} else if (body instanceof String) {
			body = Problem.builder().title(status.getReasonPhrase()).status(status.value())
					.userMessage(MSG_ERRO_SISTEMA)
					.build();
		}

		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Throwable rootCause = ExceptionUtils.getRootCause(ex);

		if (rootCause instanceof InvalidFormatException) {
			return handleInvalidFormat((InvalidFormatException) rootCause, headers, status, request);
		} else if (rootCause instanceof PropertyBindingException) {
			return handlePropertyBinding((PropertyBindingException) rootCause, headers, status, request);
		}

		var problemType = ProblemType.MENSAGEM_INCOMPREENSIVEL;
		var detail = "O corpo da requisição está inválido, verifique erro de sintaxe";
		var problem = createProblemBuilder(status, problemType, detail)
				.userMessage(MSG_ERRO_SISTEMA)
				.build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		if(ex instanceof MethodArgumentTypeMismatchException) {			
			return handleMethodArgumentTypeMismatch((MethodArgumentTypeMismatchException) ex, headers, status, request);
		}
		
		return super.handleTypeMismatch(ex, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		var problemType = ProblemType.RECURSO_NAO_ENCONTRADO;
		var detail = String.format("O recurso %s que você tentou acessar é inexistente", ex.getRequestURL());
		var problem = createProblemBuilder(status, problemType, detail)
				.userMessage(MSG_ERRO_SISTEMA)
				.build();
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return handleValidationInternal(ex, ex.getBindingResult(), headers, status, request);
	}

	private ResponseEntity<Object> handleValidationInternal(Exception ex, BindingResult bindingResult, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		var problemType = ProblemType.DADOS_INVALIDOS;
		var detail = "Um ou mais campos estão incorretos, faça o preenchimento correto e tente novamente.";


		List<Problem.Object> problemObject = bindingResult.getAllErrors().stream().map(objectError -> {
			
			String name = objectError.getObjectName();
					
			if (objectError instanceof FieldError) {
				name = ((FieldError) objectError).getField();
			}
			
			String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
			return Problem.Object.builder().name(name).userMessage(message)
					.build();
		}).collect(Collectors.toList());

		var problem = createProblemBuilder(status, problemType, detail).userMessage(detail).objects(problemObject)
				.build();

		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		var detail = String.format(
				"O parametro de URL '%s' recebeu o valor '%s' que é de um tipo inválido, corrija e informe um valor compatível com o tipo %s",
				ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName());
		var problemType = ProblemType.PARAMETRO_INVALIDO;
		var problem = createProblemBuilder(status, problemType, detail)
				.userMessage(MSG_ERRO_SISTEMA)
				.build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	private ResponseEntity<Object> handlePropertyBinding(PropertyBindingException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		var pathString = joinPath(ex.getPath());
		var problemType = ProblemType.MENSAGEM_INCOMPREENSIVEL;
		String detail = String.format(
				"A propriedade '%s' não existe. " + "Corrija ou remova essa propriedade e tente novamente.",
				pathString);
		
		var problem = createProblemBuilder(status, problemType, detail)
				.userMessage(MSG_ERRO_SISTEMA)
				.build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	private String joinPath(List<Reference> references) {
		return references.stream().map(ref -> ref.getFieldName()).collect(Collectors.joining("."));
	}

	private ResponseEntity<Object> handleInvalidFormat(InvalidFormatException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		var pathString = joinPath(ex.getPath());

		var problemType = ProblemType.MENSAGEM_INCOMPREENSIVEL;
		String detail = String.format(
				"A propriedade '%s' recebeu o valor '%s' que é de um tipo inválido. "
						+ "Corrija  e informe um valor compatível com o tipo %s' ",
				pathString, ex.getValue(), ex.getTargetType().getSimpleName());

		var problem = createProblemBuilder(status, problemType, detail)
				.userMessage(MSG_ERRO_SISTEMA)
				.build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail) {
		return Problem.builder().status(status.value()).type(problemType.getUri()).title(problemType.getTitle())
				.detail(detail).timestamp(OffsetDateTime.now());
	}

}
