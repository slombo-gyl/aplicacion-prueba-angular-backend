package backend.Aplicacion.services.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;

import java.util.List;

public interface EstudianteService {
    EstudianteDTOResponse create(EstudianteDTORequest req);

    List<EstudianteDTOResponse> getAll();

    EstudianteDTOResponse getById(Long id);


    EstudianteDTOResponse update(Long id, EstudianteDTORequest req);

    EstudianteDTOResponse delete(Long id);

    EstudianteDTOResponse activar(Long id);


}