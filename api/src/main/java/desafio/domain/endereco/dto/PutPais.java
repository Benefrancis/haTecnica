package desafio.domain.endereco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.endereco.Pais;
import jakarta.validation.constraints.NotBlank;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutPais(
        Long id,
        @NotBlank
        String nome
) {
    public PutPais(Pais p) {
        this(
                p.getId(),
                p.getNome()
        );
    }
}
