package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface ActualizarEstudianteUseCase {
    EstudianteDTOResponse ejecutar(Long id, ActualizarEstudianteDTORequest dto);
}
