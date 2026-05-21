package backend.Aplicacion.dto.puntaje;

import java.util.List;


public record PuntajesDTOResponse(
        List<String> labels,
        List<Integer> data

) {
}
