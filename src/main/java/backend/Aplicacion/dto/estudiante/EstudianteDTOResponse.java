package backend.Aplicacion.dto.estudiante;

public record EstudianteDTOResponse(
        Long id,
        String nombre,
        String apellido,
        String email,
        int dni
) {}