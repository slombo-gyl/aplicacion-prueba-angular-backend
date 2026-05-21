package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.MateriaDTOResponse;

import java.util.List;

public interface ObtenerListaMateriasUseCase {
    List<MateriaDTOResponse> ejecutar();

    List<MateriaDTOResponse> ejecutar(boolean activo);
}