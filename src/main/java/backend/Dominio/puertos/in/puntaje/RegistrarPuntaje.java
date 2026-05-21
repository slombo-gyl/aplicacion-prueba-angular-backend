package backend.Dominio.puertos.in.puntaje;

import backend.Dominio.modelo.PuntajeModel;

public interface RegistrarPuntaje {

    PuntajeModel guardar (PuntajeModel puntajeModel, Long materiaId, Long estudianteId);
}
