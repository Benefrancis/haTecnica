package desafio.domain.cliente.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.cliente.TipoCliente;
import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutTipoCliente(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
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
