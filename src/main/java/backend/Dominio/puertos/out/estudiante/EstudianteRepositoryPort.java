package backend.Dominio.puertos.out.estudiante;

import backend.Dominio.modelo.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepositoryPort {
    Estudiante guardar(Estudiante estudiante);
    Optional<Estudiante> obtenerPorId(Long id);
    List<Estudiante> obtenerTodosLosEstudiantesActivos();
    Optional<Estudiante> obtenerActivoPorId(Long id);
}
