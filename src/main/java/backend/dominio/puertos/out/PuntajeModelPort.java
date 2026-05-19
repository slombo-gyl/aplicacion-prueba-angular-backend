package backend.dominio.puertos.out;

import backend.dominio.modelos.PuntajeModel;

public interface PuntajeModelPort {
    PuntajeModel guardar(PuntajeModel puntaje,Long materiaId, Long estudianteId);
}