package com.algawors.algafood.auth.core;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;

import com.algawors.algafood.auth.domain.Usuario;

import lombok.Getter;

@Getter
public class AuthUser extends User {

	private static final long serialVersionUID = 1L;
	
	private String fullName;
	/*
	 *  a senha passada no super tem que estar criptografada com Bcrypt
	 */
	public AuthUser(Usuario usuario) {
		super(usuario.getEmail(), usuario.getSenha(), Collections.emptyList());
	
		this.fullName = usuario.getNome();
	}
	
}
