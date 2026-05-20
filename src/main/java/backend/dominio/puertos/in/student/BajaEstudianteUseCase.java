package backend.dominio.puertos.in.student;

import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;

public interface BajaEstudianteUseCase {
    EstadoEstudianteDTOResponse bajaEstudianteUseCase(Long id);
}