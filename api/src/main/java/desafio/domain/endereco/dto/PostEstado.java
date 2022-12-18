package desafio.domain.endereco.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PostEstado(

        @NotBlank
        String nome,

        @NotBlank
        String sigla,

        @NotBlank
        @Valid
        PutPais pais

) {

    public PostEstado(@NotBlank
                      String nome,
                      @NotBlank
                      String sigla,
                      @Valid
                      PutPais pais) {
        this.nome = nome;
        this.pais = pais;
        this.sigla = sigla;
    }
}
