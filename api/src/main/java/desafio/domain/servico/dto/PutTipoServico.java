package desafio.domain.servico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.servico.TipoServico;
import jakarta.validation.constraints.NotBlank;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutTipoServico(

        Long id,

        @NotBlank
        String nome


) {
    public PutTipoServico(TipoServico ts) {
        this(ts.getId(), ts.getNome());
    }
}
