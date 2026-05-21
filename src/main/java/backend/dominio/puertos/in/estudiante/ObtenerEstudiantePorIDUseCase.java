package backend.dominio.puertos.in.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;

public interface ObtenerEstudiantePorIDUseCase {EstudianteDTOResponse ejecutar(Long Id);}