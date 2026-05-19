package backend.infraestructura.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecursoInactivoException extends RuntimeException {
    public RecursoInactivoException(String message) {
        super(message);
    }
}