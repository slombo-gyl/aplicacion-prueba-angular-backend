package backend.dominio.puertos.in.student;

import backend.dominio.modelo.Estudiante;

public interface ActualizarEstudianteUseCases {
    Estudiante actualizarEstudianteUseCase(Long id, Estudiante estudiante);
}