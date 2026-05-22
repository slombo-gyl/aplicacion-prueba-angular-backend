package backend.dominio.puertos.out.puntaje;

import backend.dominio.modelo.Puntaje;

import java.util.List;

public interface PuntajeModelPort {
    Puntaje guardar(Puntaje puntaje);
    List<Puntaje> obtenerPorEstudianteId(Long id);
    List<Puntaje> obtenerPorMateriaId(Long id);
}