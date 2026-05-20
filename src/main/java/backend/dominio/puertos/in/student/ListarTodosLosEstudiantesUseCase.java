package backend.dominio.puertos.in.student;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;

import java.util.List;

public interface ListarTodosLosEstudiantesUseCase {

    List<EstudianteDTOResponse> listarTodosLosEstudiantesUseCase();
}
