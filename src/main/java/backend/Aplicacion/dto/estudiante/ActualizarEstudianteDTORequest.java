package backend.Aplicacion.dto.estudiante;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record ActualizarEstudianteDTORequest (
        String nombre,
        String apellido,
        @Email(message = "Debe tener un formato de email válido")
        String email,
        @Pattern(regexp = "\\d{7,8}", message = "El DNI debe tener 7 u 8 dígitos")
        String dni
) {

}
