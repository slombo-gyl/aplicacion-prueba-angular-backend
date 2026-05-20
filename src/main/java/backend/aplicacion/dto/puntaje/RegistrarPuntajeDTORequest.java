package backend.aplicacion.dto.puntaje;

import jakarta.validation.constraints.*;

public record RegistrarPuntajeDTORequest(

        @NotNull(message = "El estudiante es requerido")
        Long estudianteId,

        @NotNull(message = "La materia es requerida")
        Long materiaId,

        @NotNull(message = "El puntaje es requerido")
        @DecimalMin(value = "0.0", inclusive = true, message = "El puntaje no puede ser menor a 0")
        @DecimalMax(value = "10.0", inclusive = true, message = "El puntaje no puede ser mayor a 10")
        Double valor
) { }