package desafio.domain.endereco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.domain.endereco.Cidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutCidade(
        Long id,
        @NotBlank
        String nome,

        @NotNull
        @Valid
        PutEstado estado
) {
    public PutCidade(Cidade c) {
        this(
                c.getId(),
                c.getNome(),
                new PutEstado(c.getEstado())
        );
    }
}
