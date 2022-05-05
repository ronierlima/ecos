package br.ufc.quixada.ecos.domain.listener;

import br.ufc.quixada.ecos.core.security.EcosSecurity;
import br.ufc.quixada.ecos.domain.model.CustomRevisionEntity;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRevisionListener implements RevisionListener {

	@Autowired
	private EcosSecurity ecosSecurity;
	
	@Override
	public void newRevision(Object revisionEntity) {
		CustomRevisionEntity revision = (CustomRevisionEntity) revisionEntity;		

		try {
			revision.setNomeUsuario(ecosSecurity.getNomeUsuario());
			revision.setCodigoUsuario(ecosSecurity.getCodigoUsuario());
		} catch (Exception e) {
			revision.setNomeUsuario("NAO_AUTENTICADO");			
		}

	}
}