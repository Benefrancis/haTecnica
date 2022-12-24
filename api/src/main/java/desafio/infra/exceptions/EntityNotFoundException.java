package desafio.infra.exceptions;

import java.util.function.Supplier;

public class EntityNotFoundException extends RuntimeException implements Supplier<EntityNotFoundException> {
    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public EntityNotFoundException get() {
        return this;
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
