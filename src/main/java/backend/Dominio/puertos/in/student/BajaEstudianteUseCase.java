package backend.Dominio.puertos.in.student;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;

public interface BajaEstudianteUseCase {
    EstadoEstudianteDTOResponse bajaEstudianteUseCase(Long id);
}