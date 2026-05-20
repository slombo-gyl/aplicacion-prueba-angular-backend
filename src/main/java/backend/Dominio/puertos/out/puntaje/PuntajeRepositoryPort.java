package backend.Dominio.puertos.out.puntaje;

import backend.Dominio.modelo.Puntaje;

public interface PuntajeRepositoryPort {
    Puntaje guardar(Puntaje puntaje, Long materiaId, Long estudianteId);
}
