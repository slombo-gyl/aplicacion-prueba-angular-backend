package backend.aplicacion.dto.materia;

import java.time.LocalDateTime;

public record MateriaDTOResponse(Long id, String nombre, LocalDateTime fechaBaja) {}