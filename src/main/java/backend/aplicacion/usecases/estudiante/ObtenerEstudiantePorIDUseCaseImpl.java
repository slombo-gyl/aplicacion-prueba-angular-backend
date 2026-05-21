package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.mappers.EstudianteMapper;
import backend.dominio.puertos.in.estudiante.ObtenerEstudiantePorIDUseCase;
import backend.dominio.puertos.out.EstudianteModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObtenerEstudiantePorIDUseCaseImpl implements ObtenerEstudiantePorIDUseCase {
    private final EstudianteModelPort repository;

    @Override
    public EstudianteDTOResponse ejecutar(Long id) {return EstudianteMapper.toResponseDto(repository.buscarPorId(id));}
}