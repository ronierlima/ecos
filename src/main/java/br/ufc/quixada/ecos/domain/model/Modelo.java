package br.ufc.quixada.ecos.domain.model;

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

    private String descricao = null;
    private Boolean privado = false;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "modelo_arquivo_id")
    private Anexo arquivoModelo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "preview_id")
    private Anexo arquivoPreviewModelo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @PrePersist
    private void gerarCodigo() {
        setCodigo(UUID.randomUUID());
    }

}
