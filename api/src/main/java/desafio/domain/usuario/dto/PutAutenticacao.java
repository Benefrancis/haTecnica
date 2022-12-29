package desafio.domain.usuario.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PutAutenticacao(
        @NotBlank
        String username,
        @NotBlank
        String password) {

}