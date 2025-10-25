package parte2;

/**
 * Excepción de dominio para validar edades dentro de [0, 120].
 */
public class EdadInvalidaException extends Exception {

    public EdadInvalidaException(String message) {
        super(message);
    }

    public EdadInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
