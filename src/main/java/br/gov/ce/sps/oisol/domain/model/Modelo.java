package br.gov.ce.sps.oisol.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Audited
@JsonRootName("modelo")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Modelo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID codigo;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    private Boolean privado = false;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
