package com.algaworks.algafood.core.security.authorizationserver;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.jwk.JWKSet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class JWKSetController {

	@Autowired
	private JWKSet jwkSet;
	
	@GetMapping("/.well-known/jwks.json")
	public Map<String, Object> keys() {
		log.info("JWKSet inicializado");
		return this.jwkSet.toJSONObject();
	}
	
}
