package desafio.model.cliente.dto;

import desafio.model.cliente.Pais;
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
