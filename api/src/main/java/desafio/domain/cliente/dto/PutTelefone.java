package desafio.domain.cliente.dto;

import desafio.domain.cliente.Telefone;
import jakarta.validation.constraints.NotBlank;

public record PutTelefone(
        @NotBlank
        String ddi,
        @NotBlank
        String ddd,
        @NotBlank
        String numero
) {
    public PutTelefone(Telefone t) {
        this(t.getDdi(), t.getDdd(), t.getNumero());
    }
}
