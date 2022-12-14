package desafio.model.cliente.dto;

import desafio.model.cliente.Telefone;
import jakarta.validation.constraints.NotBlank;

public record PutTelefone(


        Long id,

        @NotBlank
        String ddi,
        @NotBlank
        String ddd,
        @NotBlank
        String numero


) {
    public PutTelefone(Telefone t) {
        this(t.getId(), t.getDdi(), t.getDdd(), t.getNumero());
    }
}
