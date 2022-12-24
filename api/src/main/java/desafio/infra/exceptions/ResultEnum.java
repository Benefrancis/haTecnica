package desafio.infra.exceptions;

public enum ResultEnum implements ResultInterface {

    SUCCESS(2001, "Interface call success"),
    VALIDATE_FAILED(2002, " Falha na verificação do parâmetro"),

    COMMON_FAILED(2003, "Falha na chamada da interface"),

    FORBIDDEN(2004, "Sem permissão para acessar o recurso");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}