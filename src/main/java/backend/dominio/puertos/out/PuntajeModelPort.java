package backend.dominio.puertos.out;

import backend.dominio.modelos.PuntajeModel;

import java.util.List;

public interface PuntajeModelPort {
    PuntajeModel guardar(PuntajeModel puntaje,Long materiaId, Long estudianteId);

    PuntajeModel buscar(Long id);

    PuntajeModel buscar(Long materiaId, Long estudianteId);

    List<PuntajeModel> listar();

    List<PuntajeModel> listarDeEstudiante(Long estudianteId);

    boolean existePuntaje(Long materiaId, Long estudianteId);
}