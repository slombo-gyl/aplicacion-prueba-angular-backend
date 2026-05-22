package backend.Aplicacion.dto.estudiante;

import java.time.LocalDateTime;

public record EstudianteDTOResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        int dni,
        LocalDateTime insertFecha,
        LocalDateTime deleteFecha
) {}