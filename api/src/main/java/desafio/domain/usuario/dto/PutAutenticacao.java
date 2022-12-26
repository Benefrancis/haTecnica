package desafio.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record PutAutenticacao(

        @NotBlank
        String username,
        @NotBlank
        String password) {
}