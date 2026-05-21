package backend.aplicacion.dto.puntaje;

import java.util.List;

public record MateriaNotasDTOResponse(
        String nombreMateria,
        List<Double> notas
) {
}
