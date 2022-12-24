package desafio.infra.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Interceptar exceções uniformemente
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * catch {@code BusinessException} exceção
     */
    @ExceptionHandler({BusinessException.class})
    public Result<?> handleBusinessException(BusinessException ex) {
        return Result.failed(ex.getMessage());
    }

    /**
     * Captura a exceção {@code ForbiddenException}
     */
    @ExceptionHandler({ForbiddenException.class})
    public Result<?> handleForbiddenException(ForbiddenException ex) {
        return Result.failed(String.valueOf(ResultEnum.FORBIDDEN));
    }


    /**
     * {@ code @PathVariable} e {@code @RequestParam} O tratamento de exceção lançado quando a verificação do parâmetro falha
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public Result<?> handleConstraintViolationException(ConstraintViolationException ex) {
        if (StringUtils.hasText(ex.getMessage())) {
            Result<ConstraintViolationException> result = new Result<>();
            result.setCode(ResultEnum.VALIDATE_FAILED.getCode());
            result.setMessage(ex.getMessage());
            result.setData(ex);
            return Result.failed(result);
        }
        return Result.failed(String.valueOf(ResultEnum.VALIDATE_FAILED));
    }


    @ExceptionHandler({DataIntegrityViolationException.class})
    public Result<?> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {

        if (StringUtils.hasText(ex.getMessage())) {
            Result<DataIntegrityViolationException> result = new Result<>();
            result.setCode(ResultEnum.VALIDATE_FAILED.getCode());
            result.setMessage(ex.getMessage());
            result.setData(ex);
            return Result.failed(result);
        }

        return Result.failed(String.valueOf(ResultEnum.VALIDATE_FAILED));
    }


    /**
     * As exceções de nível superior são capturadas e processadas uniformemente. Quando outras exceções não puderem ser tratadas, opte por usar
     */
    @ExceptionHandler({Exception.class})
    public Result<?> handle(Exception ex) {
        return Result.failed(ex.getMessage());
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    public record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

}