package backend.dominio.puertos.in.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;

import java.util.List;

public interface ObtenerListaEstudiantesUseCase {
    List<EstudianteDTOResponse> ejecutar();

    List<EstudianteDTOResponse> ejecutar(boolean activo);
}