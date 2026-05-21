package backend.dominio.puertos.out.puntaje;

import backend.dominio.modelo.Puntaje;

public interface PuntajeModelPort {
    Puntaje guardar(Puntaje puntaje, Long materiaId, Long estudianteId);
}