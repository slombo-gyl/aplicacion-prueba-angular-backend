package backend.dominio.puertos.in.student;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;

public interface RegistrarEstudianteUseCase {
    EstudianteDTOResponse registrarEstudianteUseCase (RegistrarEstudianteDTORequest req);
}
