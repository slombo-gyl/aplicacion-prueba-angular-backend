package backend.Infraestructura.excepciones;

public class RecursoDuplicadoException extends RuntimeException {
    public RecursoDuplicadoException(String message) {
        super(message);
    }
}