package backend.Dominio.puertos.in.estudiante;

import backend.Dominio.modelo.EstudianteModel;

import java.util.List;
import java.util.Optional;

public interface ListarEstudiante {
    List<EstudianteModel> listarTodos();

    Optional<EstudianteModel> buscarPorId(Long id);

}