package backend.Aplicacion.dto.estudiante;

import backend.Dominio.modelo.enums.Estado;

public record EstudianteDTOResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        String dni,
        Estado estado
) { }