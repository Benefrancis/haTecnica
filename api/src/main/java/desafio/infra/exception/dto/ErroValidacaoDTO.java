package desafio.infra.exception.dto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;

public record ErroValidacaoDTO(
        HttpStatus status,
        String campo,
        String localizedMessage,
        String message,

        LocalDateTime timestamp
) {
    public ErroValidacaoDTO(FieldError erro) {
        this(HttpStatus.BAD_REQUEST, erro.getField(), erro.getDefaultMessage(), erro.getDefaultMessage(), LocalDateTime.now());
    }
}