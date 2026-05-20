package backend.dominio.puertos.in.student;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface BuscarEstudiantePorIdUseCase {

    EstudianteDTOResponse buscarEstudiantePorIdUseCase(Long id);
}
