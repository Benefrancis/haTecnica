package desafio.domain.cliente.dto;

import jakarta.validation.constraints.NotBlank;

public record PostTipoCliente(

        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String sigla
) {
    public PostTipoCliente(
                 Long id,
                @NotBlank
                String nome,
                @NotBlank
                String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }
}
