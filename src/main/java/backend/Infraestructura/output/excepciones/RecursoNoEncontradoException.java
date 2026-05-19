package backend.Infraestructura.output.excepciones;

public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String message) {
        super(message);
    }
    public RecursoNoEncontradoException(Long id) {super("No se encontró el ID: " + id);}
}
