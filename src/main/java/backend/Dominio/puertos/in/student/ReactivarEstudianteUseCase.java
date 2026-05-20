package backend.Dominio.puertos.in.student;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;

public interface ReactivarEstudianteUseCase {
    EstadoEstudianteDTOResponse reactivarEstudianteUseCase(Long id);
}
