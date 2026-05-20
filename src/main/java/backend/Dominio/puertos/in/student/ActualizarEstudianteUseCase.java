package backend.Dominio.puertos.in.student;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface ActualizarEstudianteUseCase {
    EstudianteDTOResponse actualizarEstudianteUseCase(Long id, ActualizarEstudianteDTORequest dto);
}
