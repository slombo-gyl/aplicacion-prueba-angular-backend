package backend.Aplicacion.services.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;

public interface EstudianteService {
    Long registrar(EstudianteDTORequest req);
}