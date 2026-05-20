package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;

public interface BajaEstudianteUseCase {
    EstadoEstudianteDTOResponse ejecutar(Long id);
}