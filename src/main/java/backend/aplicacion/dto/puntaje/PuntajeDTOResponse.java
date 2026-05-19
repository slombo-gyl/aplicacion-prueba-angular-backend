package backend.aplicacion.dto.puntaje;

import java.util.List;

public record PuntajeDTOResponse(List<String> labels, List<Integer> data) {}