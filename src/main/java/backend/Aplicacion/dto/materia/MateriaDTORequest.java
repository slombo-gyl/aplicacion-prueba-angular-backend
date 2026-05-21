package backend.Aplicacion.dto.materia;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MateriaDTORequest(

        @NotNull(message = "Nombre es requerido")
        @Size(max = 40, message = "El nombre de la materia es demasiado largo")
        String nombre
) {
}
