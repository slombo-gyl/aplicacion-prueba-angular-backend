package backend.infraestructura.excepciones;

import backend.aplicacion.utils.response.MensajeErrorDTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<MensajeErrorDTOResponse> construirError(String error, String mensaje, HttpStatus status) {
        return ResponseEntity.status(status).body(
                new MensajeErrorDTOResponse(error, mensaje, status.value(), LocalDateTime.now())
        );
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarNoEncontrado(RecursoNoEncontradoException excepcion) {
        return construirError("Recurso no encontrado", excepcion.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecursoInsuficienteException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarInsuficiente(RecursoInsuficienteException excepcion) {
        return construirError("Recurso insuficiente", excepcion.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RecursoDuplicadoException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarDuplicado(RecursoDuplicadoException excepcion) {
        return construirError("Recurso duplicado", excepcion.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecursoInactivoException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarInactivo(RecursoInactivoException excepcion) {
        return construirError("Recurso inactivo", excepcion.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarHttpMessageNotReadable(HttpMessageNotReadableException excepcion) {
        return construirError(
                "El cuerpo JSON es inválido o tiene formato incorrecto", excepcion.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException excepcion
    ) {
        return construirError("Parámetro con tipo inválido", excepcion.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarMissingServletRequestParameter(
            MissingServletRequestParameterException excepcion
    ) {
        return construirError(
                "Falta un parámetro obligatorio en la URL", excepcion.getMessage(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException excepcion
    ) {
        return construirError(
                "Método HTTP no permitido para este endpoint", excepcion.getMessage(),
                HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarHttpMediaTypeNotSupportedException(
            HttpMediaTypeNotSupportedException excepcion
    ) {
        return construirError(
                "Formato de texto no soportado. Usá JSON", excepcion.getMessage(),
                HttpStatus.UNSUPPORTED_MEDIA_TYPE
        );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarNoHandlerFound(NoHandlerFoundException excepcion) {
        return construirError("Endpoint no encontrado", excepcion.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarIllegalArgument(IllegalArgumentException excepcion) {
        return construirError("Argumento inválido", excepcion.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarIllegalState(IllegalStateException excepcion) {
        return construirError(
                "El recurso está en un estado que impide la operación", excepcion.getMessage(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarNoSuchElement(NoSuchElementException excepcion) {
        return construirError("Recurso inexistente", excepcion.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeErrorDTOResponse> manejarGeneral(Exception excepcion) {
        return construirError(
                "Error interno del servidor", excepcion.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}