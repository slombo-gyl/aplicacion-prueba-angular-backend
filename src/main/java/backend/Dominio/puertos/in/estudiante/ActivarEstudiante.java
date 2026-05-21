package backend.Dominio.puertos.in.estudiante;

import backend.Dominio.modelo.EstudianteModel;

public interface ActivarEstudiante {
    EstudianteModel activar(Long id);
}