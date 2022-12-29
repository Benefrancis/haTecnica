package desafio.infra.exception;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import desafio.infra.exception.dto.ErroValidacaoDTO;
import desafio.infra.exception.dto.ErrorMessageDTO;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
public class ValidateErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Exception> tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(TipoServicoNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErroJaExiste(TipoServicoNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorMessageDTO(ex));
    }


    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErroJaExiste(EntidadeNaoEncontradaException ex) {
        return ResponseEntity.status(404).body(new ErrorMessageDTO(ex));
    }


    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErroJaExiste(EntityExistsException ex) {
        return ResponseEntity.status(403).body(new ErrorMessageDTO(ex));
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErroJaExiste(ServletException ex) {
        return ResponseEntity.status(403).body(new ErrorMessageDTO(ex));
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErroJaExiste(TokenExpiredException ex) {
        return ResponseEntity.status(403).body(new ErrorMessageDTO(ex));
    }

    @ExceptionHandler(SignatureVerificationException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErroJaExiste(SignatureVerificationException ex) {
        return ResponseEntity.status(403).body(new ErrorMessageDTO(ex));
    }

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErroJaExiste(JWTCreationException ex) {
        return ResponseEntity.status(403).body(new ErrorMessageDTO(ex));
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErroJaExiste(JWTVerificationException ex) {
        return ResponseEntity.status(403).body(new ErrorMessageDTO(ex));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDTO>> tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        List<ErroValidacaoDTO> campos = erros.stream().map(ErroValidacaoDTO::new).toList();
        return ResponseEntity.badRequest().body(campos);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorMessageDTO> tratarErro400(ValidationException ex) {
        return ResponseEntity.badRequest().body(new ErrorMessageDTO(ex));
    }

}
