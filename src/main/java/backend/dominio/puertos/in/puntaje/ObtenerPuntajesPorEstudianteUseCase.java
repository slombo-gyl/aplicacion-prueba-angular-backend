package backend.dominio.puertos.in.puntaje;

import backend.aplicacion.dto.puntaje.MateriaNotasDTOResponse;

import java.util.List;

public interface ObtenerPuntajesPorEstudianteUseCase {
    List<MateriaNotasDTOResponse> ejecutar(Long id);
}
