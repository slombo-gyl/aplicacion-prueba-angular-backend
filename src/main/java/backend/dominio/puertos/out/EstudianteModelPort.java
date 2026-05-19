package backend.dominio.puertos.out;

import backend.dominio.modelos.EstudianteModel;

public interface EstudianteModelPort {
    EstudianteModel guardar(EstudianteModel estudiante);
    EstudianteModel buscarPorId(Long id);
}