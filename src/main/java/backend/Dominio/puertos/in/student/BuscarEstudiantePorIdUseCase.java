package backend.Dominio.puertos.in.student;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface BuscarEstudiantePorIdUseCase {

    EstudianteDTOResponse buscarEstudiantePorIdUseCase(Long id);
}
