package backend.Dominio.puertos.out.estudiante;

import backend.Dominio.modelo.EstudianteModel;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepositoryPort {
    EstudianteModel guardar(EstudianteModel estudentiante);

    List<EstudianteModel> listarTodos();

    Optional<EstudianteModel> buscarPorId(Long id);

    Optional<EstudianteModel> buscarPorIdIncluyendoBorrados(Long id);


    EstudianteModel actualizar(EstudianteModel estudiante);

    EstudianteModel borrar(Long id);


}
