package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.mappers.EstudianteMapper;
import backend.dominio.modelos.EstudianteModel;
import backend.dominio.puertos.in.estudiante.ActualizarEstudianteUseCase;
import backend.dominio.puertos.out.EstudianteModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActualizarEstudianteUseCaseImpl implements ActualizarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public EstudianteDTOResponse ejecutar(Long id, EstudianteDTORequest req) {
        EstudianteModel estudianteActualizado = repository.buscarPorId(id);

        estudianteActualizado.setNombre(req.nombre());
        estudianteActualizado.setApellido(req.apellido());
        estudianteActualizado.setEmail(req.email());
        estudianteActualizado.setDni(req.dni());

        repository.guardar(estudianteActualizado);

        return EstudianteMapper.toResponseDto(estudianteActualizado);
    }
}