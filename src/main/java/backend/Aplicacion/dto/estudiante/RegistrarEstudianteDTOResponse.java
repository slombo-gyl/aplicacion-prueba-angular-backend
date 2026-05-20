package backend.Aplicacion.dto.estudiante;

public record RegistrarEstudianteDTOResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        int dni
) {}