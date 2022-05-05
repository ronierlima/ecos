package br.ufc.quixada.ecos.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;

@Audited
@JsonRootName("anexo")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Anexo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID codigo;

    @NotBlank
    private String nomeArquivo;
    @NotBlank
    private String contentType;
    private Long tamanho;

    @CreationTimestamp
    @Column(name = "data_cadastro")
    private OffsetDateTime dataCadastro;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private OffsetDateTime dataAtualizacao;

    @PrePersist
    private void gerarCodigo() {
        setCodigo(UUID.randomUUID());
    }
}
