package backend.dominio.puertos.out;

import backend.dominio.modelos.EstudianteModel;

import java.util.List;

public interface EstudianteModelPort {
    EstudianteModel guardar(EstudianteModel estudiante);

    EstudianteModel buscarPorId(Long id);

    List<EstudianteModel> listar(boolean activo);

    List<EstudianteModel> listar();
}