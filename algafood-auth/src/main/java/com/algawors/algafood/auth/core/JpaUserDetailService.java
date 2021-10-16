package com.algawors.algafood.auth.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.algawors.algafood.auth.domain.Usuario;
import com.algawors.algafood.auth.domain.UsuarioRepository;

@Service
public class JpaUserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByEmail(username)
			.orElseThrow(() -> new UsernameNotFoundException("Usuário nao encontrado com email informado"));
		
		return new AuthUser(usuario);
	}

}
