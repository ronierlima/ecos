package br.gov.ce.sps.oisol.core.email;

import br.gov.ce.sps.oisol.domain.service.EnvioEmailService;
import br.gov.ce.sps.oisol.infrastructure.service.email.FakeEnvioEmailService;
import br.gov.ce.sps.oisol.infrastructure.service.email.SandboxEnvioEmailService;
import br.gov.ce.sps.oisol.infrastructure.service.email.SmtpEnvioEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
            case SANDBOX:
            	return new SandboxEnvioEmailService();
            default:
                return null;
        }
    }
}
