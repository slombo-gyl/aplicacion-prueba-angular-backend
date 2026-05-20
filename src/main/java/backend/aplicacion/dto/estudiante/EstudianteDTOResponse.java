package backend.aplicacion.dto.estudiante;

import backend.dominio.modelo.enums.Estado;

public record EstudianteDTOResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        String dni,
        Estado estado
) { }