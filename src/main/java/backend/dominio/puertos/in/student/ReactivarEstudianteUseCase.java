package backend.dominio.puertos.in.student;

import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;

public interface ReactivarEstudianteUseCase {
    EstadoEstudianteDTOResponse reactivarEstudianteUseCase(Long id);
}
