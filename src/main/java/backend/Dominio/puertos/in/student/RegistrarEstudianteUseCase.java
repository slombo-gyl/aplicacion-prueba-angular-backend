package backend.Dominio.puertos.in.student;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;

public interface RegistrarEstudianteUseCase {
    EstudianteDTOResponse registrarEstudianteUseCase (RegistrarEstudianteDTORequest req);
}
