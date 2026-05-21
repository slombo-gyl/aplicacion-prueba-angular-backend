package backend.Dominio.puertos.in.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface ActualizarEstudiante {
    EstudianteDTOResponse ejecutar (EstudianteDTORequest dto);
}