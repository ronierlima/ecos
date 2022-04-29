package br.gov.ce.sps.oisol.domain.listener;

import br.gov.ce.sps.oisol.core.security.OisolSecurity;
import br.gov.ce.sps.oisol.domain.model.CustomRevisionEntity;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRevisionListener implements RevisionListener {

	@Autowired
	private OisolSecurity oisolSecurity;
	
	@Override
	public void newRevision(Object revisionEntity) {
		CustomRevisionEntity revision = (CustomRevisionEntity) revisionEntity;		

		try {
			revision.setNomeUsuario(oisolSecurity.getNomeUsuario());			
			revision.setCodigoUsuario(oisolSecurity.getCodigoUsuario());
		} catch (Exception e) {
			revision.setNomeUsuario("NAO_AUTENTICADO");			
		}

	}
}