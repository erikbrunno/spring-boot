package com.algaworks.algafood.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.core.email.EmailProperties.TipoEmail;
import com.algaworks.algafood.domain.service.EnvioEmailService;
import com.algaworks.algafood.infraestructure.service.email.FakeEnvioEmailService;
import com.algaworks.algafood.infraestructure.service.email.SmtpEnvioEmailService;

@Configuration
public class EmailConfig {
	
	@Autowired
	private EmailProperties emailProperties;
	
	@Bean
	public EnvioEmailService envioEmailService() {
		switch (emailProperties.getImpl()) {
		case FAKE:
			return new FakeEnvioEmailService();
		case SMTP:
			return new SmtpEnvioEmailService();
		default:
			return null;
		}
	}

}