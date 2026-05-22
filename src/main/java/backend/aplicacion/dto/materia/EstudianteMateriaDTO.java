package backend.aplicacion.dto.materia;

public record EstudianteMateriaDTO(
        Long id,
        String nombre,
        String apellido,
        Double nota
) {
}
