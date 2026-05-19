package backend.aplicacion.dto.chart;

import java.util.List;

public record ChartDTOResponse(List<String> labels, List<Integer> data) {}