package br.ufc.quixada.ecos.infrastructure.service.email;

import br.ufc.quixada.ecos.domain.service.EnvioEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class FakeEnvioEmailService implements EnvioEmailService {

	@Autowired
	private ProcessadorEmailTemplate processadorEmailTemplate;
	
	@Override
	public void enviar(Mensagem mensagem) {
		String corpo = processadorEmailTemplate.processar(mensagem);

		log.info("[FAKE E-MAIL] Para: {}\n{}", mensagem.getDestinatarios(), corpo);
	}
}
