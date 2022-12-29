package desafio.infra.exception;

public class TipoServicoNotFoundException extends RuntimeException {
    public TipoServicoNotFoundException(String s) {
        super(s);
    }
}
