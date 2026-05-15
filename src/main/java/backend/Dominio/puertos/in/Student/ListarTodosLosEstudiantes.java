package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

import java.util.List;

public interface ListarTodosLosEstudiantes {

    List<EstudianteDTOResponse> ejecutar();
}
