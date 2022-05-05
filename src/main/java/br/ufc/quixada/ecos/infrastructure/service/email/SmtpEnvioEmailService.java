package br.ufc.quixada.ecos.infrastructure.service.email;

import br.ufc.quixada.ecos.core.email.EmailProperties;
import br.ufc.quixada.ecos.domain.service.EnvioEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SmtpEnvioEmailService implements EnvioEmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	protected EmailProperties emailProperties;
	
	@Autowired
	private ProcessadorEmailTemplate processadorEmailTemplate;
	
	@Override
	public void enviar(Mensagem mensagem) {
		try {
			mailSender.send(criarMimeMessage(mensagem));		
		} catch (Exception e) {
			throw new EmailException("Não foi possível enviar e-mail", e);
		}
	}
	
	protected MimeMessage criarMimeMessage(Mensagem mensagem) throws MessagingException {
	    MimeMessage mimeMessage = mailSender.createMimeMessage();
	    
	    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
	    helper.setFrom(emailProperties.getRemetente());
	    helper.setTo(mensagem.getDestinatarios().toArray(new String[0]));
	    helper.setSubject(mensagem.getAssunto());
	    helper.setText(processadorEmailTemplate.processar(mensagem), true);
	    
	    return mimeMessage;
	}	
}
