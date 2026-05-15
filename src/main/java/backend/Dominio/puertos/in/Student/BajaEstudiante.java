package backend.Dominio.puertos.in.Student;

import backend.Aplicacion.dto.estudiante.BajaEstudianteDTOResponse;

public interface BajaEstudiante {
    BajaEstudianteDTOResponse ejecutar(Long id);
}