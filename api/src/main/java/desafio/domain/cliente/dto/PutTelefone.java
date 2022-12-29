package desafio.domain.cliente.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.cliente.Telefone;
import jakarta.validation.constraints.NotBlank;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutTelefone(
        @NotBlank
        String ddi,
        @NotBlank
        String ddd,
        @NotBlank
        String numero
) {
    public PutTelefone(Telefone t) {

        this(
                t.getDdi(),
                t.getDdd(),
                t.getNumero()
        );
    }
}
