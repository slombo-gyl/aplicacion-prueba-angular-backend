package backend.dominio.puertos.in.student;

import backend.dominio.modelo.Estudiante;

public interface ReactivarEstudianteUseCase {
    Estudiante reactivarEstudianteUseCase(Long id);
}