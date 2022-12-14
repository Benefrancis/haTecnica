package desafio.model.cliente.dto;

import jakarta.validation.constraints.NotBlank;

public record PostPais(

        @NotBlank
        String nome

) {

        public PostPais(@NotBlank
                        String nome) {
                this.nome = nome;
        }
}
