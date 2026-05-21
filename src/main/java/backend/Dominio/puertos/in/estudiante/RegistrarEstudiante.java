package backend.Dominio.puertos.in.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;

public interface RegistrarEstudiante {
    Long ejecutar (EstudianteDTORequest req);
}
