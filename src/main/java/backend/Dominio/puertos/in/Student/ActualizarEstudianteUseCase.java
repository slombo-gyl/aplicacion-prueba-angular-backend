package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface ActualizarEstudianteUseCase {
    EstudianteDTOResponse actualizarEstudianteUseCase(Long id, ActualizarEstudianteDTORequest dto);
}
