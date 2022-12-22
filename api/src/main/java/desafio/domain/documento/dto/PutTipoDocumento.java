package desafio.domain.documento.dto;

import desafio.domain.documento.TipoDocumento;

public record PutTipoDocumento(

        Long id,

        String nome

) {

    public PutTipoDocumento(TipoDocumento t) {
        this(t.getId(), t.getNome());
    }
}
