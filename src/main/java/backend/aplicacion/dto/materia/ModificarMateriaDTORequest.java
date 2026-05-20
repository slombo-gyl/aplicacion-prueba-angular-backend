package backend.aplicacion.dto.materia;

import jakarta.validation.constraints.*;

public record ModificarMateriaDTORequest(

        @NotBlank(message = "El nombre es requerido")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String nombre
) { }