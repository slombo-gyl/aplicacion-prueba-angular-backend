package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;

public interface ReactivarEstudianteUseCase {
    EstadoEstudianteDTOResponse ejecutar(Long id);
}
