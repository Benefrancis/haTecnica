package desafio.model.cliente.dto;

import desafio.model.cliente.TipoCliente;
import jakarta.validation.constraints.NotBlank;

public record PutTipoCliente(


        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String sigla


) {


    public PutTipoCliente(TipoCliente t) {
        this(t.getId(), t.getNome(), t.getSigla());
    }


}
