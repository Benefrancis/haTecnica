package desafio.model.cliente;


@FunctionalInterface
public interface Validavel<T> {
    boolean validar(T t);
}
