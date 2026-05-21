package backend.aplicacion.services.estudiante;

import backend.aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;

import java.util.List;

public interface EstudianteService {
    EstudianteDTOResponse registrar(RegistrarEstudianteDTORequest estudianteDto);
    List<EstudianteDTOResponse> listarTodosLosEstudiantes();
    EstudianteDTOResponse buscarPorId(Long id);
    EstudianteDTOResponse actualizar(Long id, ActualizarEstudianteDTORequest estudianteDtoToUpdate);
    EstadoEstudianteDTOResponse baja(Long id);
    EstadoEstudianteDTOResponse reactivar(Long id);
}