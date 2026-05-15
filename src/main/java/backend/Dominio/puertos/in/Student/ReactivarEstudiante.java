package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;

public interface ReactivarEstudiante {
    EstadoEstudianteDTOResponse ejecutar(Long id);
}
