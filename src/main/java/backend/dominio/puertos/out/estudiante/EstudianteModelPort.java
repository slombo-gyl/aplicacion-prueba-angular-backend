package backend.dominio.puertos.out.estudiante;

import backend.dominio.modelo.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteModelPort {
    Estudiante guardar(Estudiante estudiante);
    Optional<Estudiante> obtenerInactivoPorId(Long id);
    List<Estudiante> obtenerTodosLosEstudiantesActivos();
    Optional<Estudiante> obtenerActivoPorId(Long id);
    Estudiante actualizar(Estudiante estudiante);
    Estudiante borrar(Estudiante estudiante);
    Estudiante reactivar(Estudiante estudiante);

    Optional<Estudiante> findByEmail(String email);
    Optional<Estudiante> findByDni(String dni);
}