package backend.Aplicacion.usecases.estudiante;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.puertos.in.Student.ActualizarEstudianteUseCase;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.Infraestructura.exception.NoEncontradoException;
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
