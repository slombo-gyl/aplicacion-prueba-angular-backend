package backend.aplicacion.services.estudiante;

import backend.aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EstudianteService {
    EstudianteDTOResponse registrar(RegistrarEstudianteDTORequest estudianteDto);
    Page<EstudianteDTOResponse> listarTodosLosEstudiantes(Pageable pageable);
    EstudianteDTOResponse buscarPorId(Long id);
    EstudianteDTOResponse actualizar(Long id, ActualizarEstudianteDTORequest estudianteDtoToUpdate);
    EstadoEstudianteDTOResponse baja(Long id);
    EstadoEstudianteDTOResponse reactivar(Long id);
}