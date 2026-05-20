package backend.aplicacion.dto.estudiante;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Pattern;

public record ActualizarEstudianteDTORequest(

        @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
        String nombre,

        @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
        String apellido,

        @Email(message = "Debe tener un formato de email válido")
        @Size(max = 100, message = "El email no puede superar los 100 caracteres")
        String email,

        @Pattern(regexp = "\\d{7,8}", message = "El DNI debe tener 7 u 8 dígitos")
        String dni
) { }