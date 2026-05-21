package backend.Aplicacion.dto.puntaje;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PuntajeDTORequest(

        @NotNull(message = "Estudiante es requerido")
        Long estudianteId,

        @NotNull(message = "Materia requerido")
        Long materiaId,

        @NotNull(message = "Puntaje es requerido")
        @Positive(message = "La nota no puede ser menor a 0")
        @Max(value = 10, message = "La nota no puede ser mayor a 0")
        double valor
) {
}
