package backend.Dominio.puertos.in.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface BorrarEstudiante {
    EstudianteDTOResponse ejecutar (Long id);
}
