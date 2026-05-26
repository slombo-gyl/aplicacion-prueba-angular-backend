package backend.dominio.puertos.in.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;

import java.util.List;

public interface ObtenerPuntajesDeEstudianteUseCase {
    List<PuntajeDTOResponse> ejecutar(Long EstudianteID);
}