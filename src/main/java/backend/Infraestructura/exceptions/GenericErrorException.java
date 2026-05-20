package backend.Infraestructura.exceptions;

public class GenericErrorException extends RuntimeException {
    public GenericErrorException(String message) {
        super(message);
    }
}
