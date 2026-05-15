package backend.Aplicacion.dto.estudiante;

import backend.Dominio.modelo.enums.Estado;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegistrarEstudianteDTORequest(
        @NotNull(message = "Nombre es requerido")
        String nombre,

        @NotNull(message = "Apellido es requerido")
        String apellido,

        @NotNull(message = "Email es requerido")
        String email,

        @Pattern(regexp = "\\d{7,8}", message = "El DNI debe tener 7 u 8 dígitos")
        String dni
//
//        @NotNull(message = "Estado es requerido")
//        Estado estado
) {
}
