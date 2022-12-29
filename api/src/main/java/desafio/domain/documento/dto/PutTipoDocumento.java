package desafio.domain.documento.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.documento.TipoDocumento;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutTipoDocumento(

        Long id,

        String nome

) {

    public PutTipoDocumento(TipoDocumento t) {
        this(t.getId(), t.getNome());
    }
}
