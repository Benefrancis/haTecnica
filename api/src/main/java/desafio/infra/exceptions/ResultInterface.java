package desafio.infra.exceptions;

//Define a estrutura de dados de retorno
public interface ResultInterface {
    Integer getCode();

    String getMessage();
}