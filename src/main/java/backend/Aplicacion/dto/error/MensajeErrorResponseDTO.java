package backend.Aplicacion.dto.error;

import java.time.LocalDateTime;

public record MensajeErrorResponseDTO(String error, String mensaje, int estado, LocalDateTime fecha) {}