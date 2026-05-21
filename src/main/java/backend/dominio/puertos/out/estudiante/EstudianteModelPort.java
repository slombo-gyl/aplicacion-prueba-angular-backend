package backend.dominio.puertos.out.estudiante;

import backend.dominio.modelo.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EstudianteModelPort {
    Estudiante guardar(Estudiante estudiante);
    Optional<Estudiante> obtenerInactivoPorId(Long id);
    Page<Estudiante> obtenerTodosLosEstudiantesActivos(Pageable pageable);
    Optional<Estudiante> obtenerActivoPorId(Long id);
    Estudiante actualizar(Estudiante estudiante);
    Estudiante borrar(Estudiante estudiante);
    Estudiante reactivar(Estudiante estudiante);

    Optional<Estudiante> findByEmail(String email);
    Optional<Estudiante> findByDni(String dni);
}