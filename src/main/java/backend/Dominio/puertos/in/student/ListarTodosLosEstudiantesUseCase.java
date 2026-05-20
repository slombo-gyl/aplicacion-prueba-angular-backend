package backend.Dominio.puertos.in.student;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

import java.util.List;

public interface ListarTodosLosEstudiantesUseCase {

    List<EstudianteDTOResponse> listarTodosLosEstudiantesUseCase();
}
