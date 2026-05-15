package backend.Dominio.puertos.out.estudiante;

import backend.Dominio.modelo.EstudianteModel;

import java.util.Optional;

public interface EstudianteRepositoryPort {
    EstudianteModel guardar(EstudianteModel estudiante);
    Optional<EstudianteModel> obtenerPorId(Long id);
}
