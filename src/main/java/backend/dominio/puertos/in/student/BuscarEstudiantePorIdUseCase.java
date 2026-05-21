package backend.dominio.puertos.in.student;

import backend.dominio.modelo.Estudiante;

public interface BuscarEstudiantePorIdUseCase {

    Estudiante buscarEstudiantePorIdUseCase(Long id);
}