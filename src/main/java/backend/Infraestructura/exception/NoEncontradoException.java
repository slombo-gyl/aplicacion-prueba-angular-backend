package backend.Infraestructura.exception;

public class NoEncontradoException extends RuntimeException {

    public NoEncontradoException(String message) {
        super(message);
    }
}