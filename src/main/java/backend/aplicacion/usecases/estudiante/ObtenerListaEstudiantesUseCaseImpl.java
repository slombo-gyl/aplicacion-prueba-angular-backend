package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.mappers.EstudianteMapper;
import backend.dominio.puertos.in.estudiante.ObtenerListaEstudiantesUseCase;
import backend.dominio.puertos.out.EstudianteModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ObtenerListaEstudiantesUseCaseImpl implements ObtenerListaEstudiantesUseCase {
    private final EstudianteModelPort repository;

    @Override
    public List<EstudianteDTOResponse> ejecutar() {
        return repository.listar()
                .stream()
                .map(EstudianteMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<EstudianteDTOResponse> ejecutar(boolean activo) {
        return repository.listar(activo)
                .stream()
                .map(EstudianteMapper::toResponseDto)
                .toList();
    }
}