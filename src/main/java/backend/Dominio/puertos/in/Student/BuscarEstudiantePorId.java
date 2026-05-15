package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface BuscarEstudiantePorId {

    EstudianteDTOResponse ejecutar(Long id);
}
