package desafio.model.cliente.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PostEstado(

        @NotBlank
        String nome,

        @NotBlank
        @Valid
        PutPais pais

) {

        public PostEstado(@NotBlank
                          String nome, @NotBlank
                          @Valid
                          PutPais pais) {
                this.nome = nome;
                this.pais = pais;
        }
}
