package com.algawors.algafood.auth.core;

import java.util.HashMap;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class JwtCustomClaimsTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		if (authentication.getPrincipal() instanceof AuthUser) {
			
			var authUser = (AuthUser) authentication.getPrincipal();
			
			var info = new HashMap<String, Object>();
			info.put("nome_completo", authUser.getFullName());
			info.put("usuario_id", authUser.getUserId());
			
			//Adiciona novas claims no payload do JWT
			var oauth2AcessToken = (DefaultOAuth2AccessToken) accessToken;
			oauth2AcessToken.setAdditionalInformation(info);
		}
		
		
		return accessToken;
	}

}
