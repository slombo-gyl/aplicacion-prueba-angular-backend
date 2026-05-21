package backend.Aplicacion.services.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface EstudianteService {
    EstudianteDTOResponse registrar(EstudianteDTORequest req);
}