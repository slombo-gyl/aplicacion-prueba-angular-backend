package backend.aplicacion.dto.estudiante;

import backend.dominio.modelo.enums.Estado;

public record EstadoEstudianteDTOResponse(
        Long id,
        Estado estado
) { }