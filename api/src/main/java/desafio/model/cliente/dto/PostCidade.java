package desafio.model.cliente.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PostCidade(

        @NotBlank
        String nome,

        @NotBlank
        @Valid
        PutEstado estado) {

        public PostCidade(@NotBlank
                          String nome, @NotBlank
                          @Valid
                          PutEstado estado) {
                this.nome = nome;
                this.estado = estado;
        }
}
