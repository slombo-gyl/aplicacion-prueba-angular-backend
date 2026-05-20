package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.ActualizarEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteUseCaseImpl implements ActualizarEstudianteUseCase {

    private final EstudianteModelPort repository;


    @Override
    public EstudianteDTOResponse actualizarEstudianteUseCase(Long id, ActualizarEstudianteDTORequest dto) {
        Estudiante estudiante = repository.obtenerPorId(id).
                orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));

        EstudianteDTOMapper.updateModelFromDto(dto, estudiante);
        repository.guardar(estudiante);

        return EstudianteDTOMapper.toDTOResponse(estudiante);
    }
}
