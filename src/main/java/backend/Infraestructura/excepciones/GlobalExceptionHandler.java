package backend.Infraestructura.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<MensajeErrorResponseDto> construirError(String error, String mensaje, HttpStatus status) {
        return ResponseEntity.status(status).body(
                new MensajeErrorResponseDto(error, mensaje, status.value(), LocalDateTime.now())
        );
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<String> handleNotFound(RecursoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAnything(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error al procesar los datos, verifique el contenido del método\n"
                + ex.getMessage());
    }
}