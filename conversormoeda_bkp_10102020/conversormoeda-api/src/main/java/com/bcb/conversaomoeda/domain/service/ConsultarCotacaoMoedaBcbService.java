package com.bcb.conversaomoeda.domain.service;

import static com.bcb.conversaomoeda.api.util.Constantes.PATH;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bcb.conversaomoeda.api.model.CotacaoMoedaBcbList;
import com.bcb.conversaomoeda.api.model.CotacaoMoedaBcbModel;
import com.bcb.conversaomoeda.api.util.DataUtil;

@Service
public class ConsultarCotacaoMoedaBcbService {

	private static final int PRIMEIRO_ITEM_DA_LISTA = 0;

	@Autowired
	private RestTemplate restTemplate;

	public CotacaoMoedaBcbModel consultarUltimaCotacao(String simbolo, LocalDate dataConsulta) {
	
		CotacaoMoedaBcbModel cotacaoAtual = null;

		String data = DataUtil.obterDataComoString(dataConsulta);
		String url = PATH
				+ "CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)?@moeda='%s'&@dataCotacao='%s'&$top=100&$skip=0&$orderby=dataHoraCotacao desc&$format=json&$select=cotacaoVenda,dataHoraCotacao,tipoBoletim";
		String urlFormatada = String.format(url, simbolo, data);
		CotacaoMoedaBcbList resposta = restTemplate.getForObject(urlFormatada, CotacaoMoedaBcbList.class);
	
		List<CotacaoMoedaBcbModel> cotacoes = resposta.getCotacoes();
		
		if (!cotacoes.isEmpty()) {
			cotacaoAtual = cotacoes.get(PRIMEIRO_ITEM_DA_LISTA);
		}
		
		return cotacaoAtual;
	}
	

}
