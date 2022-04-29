package br.gov.ce.sps.oisol.infrastructure.service.email;

import br.gov.ce.sps.oisol.domain.service.EnvioEmailService.Mensagem;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Component
public class ProcessadorEmailTemplate {

	@Autowired
	private Configuration freemarkerConfig;
	
	protected String processar(Mensagem mensagem) {
		try {			
			return FreeMarkerTemplateUtils.processTemplateIntoString(
					freemarkerConfig.getTemplate(mensagem.getCorpo()), 
					mensagem.getVariaveis());
		} catch (Exception e) {
			throw new EmailException("Não foi possível montar o template do e-mail", e);
		}
	}
}
