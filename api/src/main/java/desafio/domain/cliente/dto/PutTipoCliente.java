package desafio.domain.cliente.dto;

import desafio.domain.cliente.TipoCliente;

public record PutTipoCliente(
        Long id,

        String nome,

        String sigla
) {
    public PutTipoCliente(TipoCliente t) {

        this(
                t.getId(),
                t.getNome(),
                t.getSigla()
        );

    }
}
