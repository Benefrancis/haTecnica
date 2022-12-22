package desafio.domain.servico.dto;

import desafio.domain.servico.TipoServico;
import jakarta.validation.constraints.NotBlank;

public record PutTipoServico(

        Long id,

        @NotBlank
        String nome


) {
    public PutTipoServico(TipoServico ts) {
        this(ts.getId(), ts.getNome());
    }
}
