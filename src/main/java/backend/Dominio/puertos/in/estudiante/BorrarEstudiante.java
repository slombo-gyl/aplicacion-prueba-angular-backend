package backend.Dominio.puertos.in.estudiante;

import backend.Dominio.modelo.EstudianteModel;

public interface BorrarEstudiante {
    EstudianteModel borrar(Long id);
}