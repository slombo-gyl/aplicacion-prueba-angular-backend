package backend.dominio.puertos.in.student;

import backend.aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface ActualizarEstudianteUseCase {
    EstudianteDTOResponse actualizarEstudianteUseCase(Long id, ActualizarEstudianteDTORequest dto);
}
