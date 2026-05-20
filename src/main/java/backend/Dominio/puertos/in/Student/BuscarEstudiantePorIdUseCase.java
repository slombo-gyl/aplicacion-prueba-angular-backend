package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface BuscarEstudiantePorIdUseCase {

    EstudianteDTOResponse buscarEstudiantePorIdUseCase(Long id);
}
