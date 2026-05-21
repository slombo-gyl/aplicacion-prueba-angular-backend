package backend.dominio.puertos.in.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;


public interface ActualizarEstudianteUseCase {EstudianteDTOResponse ejecutar(Long Id, EstudianteDTORequest req);}