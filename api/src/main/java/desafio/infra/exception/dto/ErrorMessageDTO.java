package desafio.infra.exception.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public record ErrorMessageDTO(
        LocalDateTime timestamp,

        Integer status,

        String message,

        String localizedMessage
) {
    public ErrorMessageDTO(Exception ex) {
        this(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ex.getLocalizedMessage());
    }
}
