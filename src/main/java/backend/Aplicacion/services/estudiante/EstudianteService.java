package backend.Aplicacion.services.estudiante;

import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;

public interface EstudianteService {
    Long registrar(RegistrarEstudianteDTORequest req);
}