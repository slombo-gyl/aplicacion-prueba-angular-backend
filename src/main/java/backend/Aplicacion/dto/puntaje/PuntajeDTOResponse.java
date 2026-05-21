package backend.Aplicacion.dto.puntaje;

public record PuntajeDTOResponse(
        Long id,
        Long estudianteId,
        Long materiaId,
        double valor
) {
}
