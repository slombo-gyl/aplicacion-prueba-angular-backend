package backend.aplicacion.dto.puntaje;

import java.util.List;

public record ChartDTOResponse(List<String> labels, List<Integer> data) {}