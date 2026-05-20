package backend.Infraestructura.exceptions;

public class GenericNoContentException extends RuntimeException {
    public GenericNoContentException(String message) {
        super(message);
    }
}
