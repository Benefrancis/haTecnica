package desafio.domain.endereco.dto;

import desafio.domain.endereco.Pais;
import jakarta.validation.constraints.NotBlank;

public record PutPais(

        Long id,

        @NotBlank
        String nome

) {

    public PutPais(Pais p) {
        this(p.getId(), p.getNome());
    }
}
