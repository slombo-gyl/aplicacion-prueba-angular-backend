package backend.Aplicacion.dto.materia;


import java.time.LocalDateTime;

public record MateriaResponseDTO(

        Long id,
        String nombre,
        LocalDateTime insertFecha,
        LocalDateTime deleteFecha

) {
}
