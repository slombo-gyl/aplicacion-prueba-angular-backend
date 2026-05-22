package backend.Aplicacion.services.puntaje;

import backend.Aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.Aplicacion.dto.puntaje.PuntajeDTOResponse;

import java.util.List;

public interface PuntajeService {

    PuntajeDTOResponse create(PuntajeDTORequest puntajeDto);
    List<PuntajeDTOResponse> getByEstudianteId(Long estudianteId);
    List<PuntajeDTOResponse> listarTodos();

    PuntajeDTOResponse update(Long puntajeId, PuntajeDTORequest puntajeDtoToUpdate);
}
