package desafio.domain.endereco.dto;

import desafio.domain.endereco.Estado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutEstado(


        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String sigla,

        @NotNull
        @Valid
        PutPais pais


) {

    public PutEstado(Estado e) {
        this(e.getId(), e.getNome(), e.getSigla(), new PutPais(e.getPais()));
    }
}
