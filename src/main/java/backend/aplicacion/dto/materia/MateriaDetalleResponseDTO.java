package backend.aplicacion.dto.materia;

import java.util.List;

public record MateriaDetalleResponseDTO(
        Long id,
        String nombre,
        Double promedio,
        List<EstudianteMateriaDTO> alumnos
) {
}
