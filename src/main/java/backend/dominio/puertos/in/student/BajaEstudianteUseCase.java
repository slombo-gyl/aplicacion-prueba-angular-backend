package backend.dominio.puertos.in.student;

import backend.dominio.modelo.Estudiante;

public interface BajaEstudianteUseCase {
    Estudiante bajaEstudianteUseCase(Long id);
}