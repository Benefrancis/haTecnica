package desafio.model.cliente.dto;

import desafio.model.cliente.Estado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutEstado(


        Long id,

        @NotBlank
        String nome,

        @NotNull
        @Valid
        PutPais pais


) {

    public PutEstado(Estado e) {
        this(e.getId(), e.getNome(), new PutPais(e.getPais()));
    }
}
