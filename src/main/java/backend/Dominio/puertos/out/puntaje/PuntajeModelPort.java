package backend.Dominio.puertos.out.puntaje;

import backend.Dominio.modelo.Puntaje;

public interface PuntajeModelPort {
    Puntaje guardar(Puntaje puntaje, Long materiaId, Long estudianteId);
}
