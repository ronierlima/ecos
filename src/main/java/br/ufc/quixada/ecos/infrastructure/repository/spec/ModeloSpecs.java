package br.ufc.quixada.ecos.infrastructure.repository.spec;

import br.ufc.quixada.ecos.domain.filter.ModeloFilter;
import br.ufc.quixada.ecos.domain.model.Modelo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;

public class ModeloSpecs {

	public static Specification<Modelo> usandoFiltro(ModeloFilter filtro) {
		return (root, query, builder) -> {

			query.distinct(true);

			var predicates = new ArrayList<Predicate>();

			if (filtro.getCodigo() != null) {
				predicates.add(builder.equal(root.get("codigo"), filtro.getCodigo()));
			}

			if (filtro.getPrivado() != null) {
				predicates.add(builder.equal(root.get("privado"), filtro.getPrivado()));
			}

			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}

}
