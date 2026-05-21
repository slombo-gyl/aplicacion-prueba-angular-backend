package backend.Aplicacion.dto.estudiante;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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
        @Pattern(regexp = "^\\d{8}$", message = "Numero de DNI invalido")
        int dni
) {
}
