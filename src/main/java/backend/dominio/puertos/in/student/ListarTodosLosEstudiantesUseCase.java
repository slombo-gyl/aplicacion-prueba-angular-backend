package backend.dominio.puertos.in.student;

import backend.dominio.modelo.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListarTodosLosEstudiantesUseCase {
    Page<Estudiante> listarTodosLosEstudiantesUseCase(Pageable pageable);
}