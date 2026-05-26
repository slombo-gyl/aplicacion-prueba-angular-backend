package backend.dominio.puertos.in.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;

public interface ObtenerPuntajeSegunEstudianteYMateriaUseCase {
    PuntajeDTOResponse ejecutar(Long EstudianteID, Long MateriaID);
}