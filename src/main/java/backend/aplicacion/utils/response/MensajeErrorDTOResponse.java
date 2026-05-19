package backend.aplicacion.utils.response;

import java.time.LocalDateTime;

public record MensajeErrorDTOResponse(String error, String mensaje, int estado, LocalDateTime fecha) {}