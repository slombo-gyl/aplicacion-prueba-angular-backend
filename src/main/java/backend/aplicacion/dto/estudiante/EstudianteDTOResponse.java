package backend.aplicacion.dto.estudiante;

import java.time.LocalDateTime;

public record EstudianteDTOResponse (
        Long id, String nombre, String apellido, String email, int dni, LocalDateTime fechaBaja
) {}