package backend.dominio.puertos.out.estudiante;

import backend.dominio.modelo.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteModelPort {
    Estudiante guardar(Estudiante estudiante);
    Optional<Estudiante> obtenerPorId(Long id);
    List<Estudiante> obtenerTodosLosEstudiantesActivos();
    Optional<Estudiante> obtenerActivoPorId(Long id);
    Estudiante actualizar(Long id, Estudiante estudiante);
    Estudiante borrar(Long id);
    Estudiante reactivarPorId(Long id);
}