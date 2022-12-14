package desafio.model.cliente.dto;

import desafio.model.cliente.TipoCliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PutTipoCliente(


        Long id,

        String nome,


        String sigla


) {


    public PutTipoCliente(TipoCliente t) {
        this(t.getId(), t.getNome(), t.getSigla());
    }


}
