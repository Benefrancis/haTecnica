package desafio.infra.exception.dto;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public record ErrorMessageDTO(
        LocalDateTime timestamp,

        HttpStatus status,

        String message,

        String localizedMessage
) {
    public ErrorMessageDTO(Exception ex) {
        this(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                ex.getLocalizedMessage()
        );
    }
}
