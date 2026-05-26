package backend.aplicacion.dto.puntaje;

import jakarta.validation.constraints.NotNull;

public record PuntajeDTORequest(
        @NotNull(message = "Estudiante es requerido") Long estudianteId,
        @NotNull(message = "Materia requerido") Long materiaId,
        @NotNull(message = "Puntaje es requerido") double valor
) {}