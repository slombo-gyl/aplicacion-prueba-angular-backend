package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;

public interface RegistrarEstudianteUseCase {
    EstudianteDTOResponse ejecutar (RegistrarEstudianteDTORequest req);
}
