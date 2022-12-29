package desafio.domain.endereco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.endereco.Estado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutEstado(


        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String sigla,

        @NotNull
        @Valid
        PutPais pais,


        Long ibge


) {

    public PutEstado(Estado e) {
        this(
                e.getId(),
                e.getNome(),
                e.getSigla(),
                new PutPais(e.getPais()),
                e.getIbge()
        );
    }
}
