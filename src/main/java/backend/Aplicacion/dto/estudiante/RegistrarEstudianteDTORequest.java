package backend.Aplicacion.dto.estudiante;

public record RegistrarEstudianteDTORequest(
        String nombre,
        String apellido,
        String email,
        int dni
) {
}
