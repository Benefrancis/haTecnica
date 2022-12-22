package desafio.domain.endereco.dto;

import desafio.domain.endereco.Cidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutCidade(
        Long id,
        @NotBlank
        String nome,

        @NotNull
        @Valid
        PutEstado estado
) {
    public PutCidade(Cidade c) {
        this(
                c.getId(),
                c.getNome(),
                new PutEstado(c.getEstado())
        );
    }
}
