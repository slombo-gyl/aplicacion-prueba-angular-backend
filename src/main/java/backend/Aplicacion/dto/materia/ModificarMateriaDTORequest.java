package backend.Aplicacion.dto.materia;

import jakarta.validation.constraints.NotNull;

public record ModificarMateriaDTORequest(
        @NotNull(message = "nombre es requirido")
        String nombre
) {

}
