package backend.Aplicacion.dto.estudiante;

import jakarta.validation.constraints.*;

public record EstudianteDTORequest(
        @NotNull(message = "Nombre es requerido")
        @Size(max = 30, message = "Nombre demasiado largo")
        String nombre,

        @NotNull(message = "Apellido es requerido")
        @Size(max = 30, message = "Apellido demasiado largo")
        String apellido,

        @NotNull(message = "Email es requerido")
        @Email
        String email,

        @NotNull(message = "Dni es requerido")
        @Digits(integer = 8, fraction = 0, message = "Numero de DNI invalido")
        Integer dni
) {
}
