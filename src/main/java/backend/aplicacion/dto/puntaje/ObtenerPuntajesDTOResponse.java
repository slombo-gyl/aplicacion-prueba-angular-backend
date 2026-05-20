package backend.aplicacion.dto.puntaje;

import java.util.List;

public record ObtenerPuntajesDTOResponse(
        List<String> labels,
        List<Double> data
) { }