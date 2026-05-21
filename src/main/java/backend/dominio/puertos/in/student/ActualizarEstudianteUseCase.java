package backend.dominio.puertos.in.student;

import backend.dominio.modelo.Estudiante;

public interface ActualizarEstudianteUseCase {
    Estudiante actualizarEstudianteUseCase(Long id, Estudiante estudiante);
}