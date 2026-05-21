package backend.Aplicacion.dto.puntaje;

import java.time.LocalDateTime;

public record PuntajeDTOResponse(
        Long id,
        Long estudianteId,
        Long materiaId,
        double valor,
        LocalDateTime fechaInsert
) {
}
