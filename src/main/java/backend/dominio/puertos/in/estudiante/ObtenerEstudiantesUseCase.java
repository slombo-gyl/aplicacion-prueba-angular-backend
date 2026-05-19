package backend.dominio.puertos.in.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface ObtenerEstudiantesUseCase {
    EstudianteDTOResponse ejecutar(Long Id);
}