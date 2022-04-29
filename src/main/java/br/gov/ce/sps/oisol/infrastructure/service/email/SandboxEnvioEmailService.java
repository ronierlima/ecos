package br.gov.ce.sps.oisol.infrastructure.service.email;

import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class SandboxEnvioEmailService extends SmtpEnvioEmailService {
    @Override
    protected MimeMessage criarMimeMessage(Mensagem mensagem) throws MessagingException {
        MimeMessage mimeMessage = super.criarMimeMessage(mensagem);
        
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
        helper.setTo(super.emailProperties.getSandbox().getDestinatario());
        
        return mimeMessage;
    }	
}
