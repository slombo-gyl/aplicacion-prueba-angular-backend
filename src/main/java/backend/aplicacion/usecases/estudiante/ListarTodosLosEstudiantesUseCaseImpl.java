package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.dominio.puertos.in.student.ListarTodosLosEstudiantesUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodosLosEstudiantesUseCaseImpl implements ListarTodosLosEstudiantesUseCase {

    private final EstudianteModelPort repository;

    @Override
    public List<EstudianteDTOResponse> listarTodosLosEstudiantesUseCase() {
        return repository.obtenerTodosLosEstudiantesActivos().
                stream().map(EstudianteDTOMapper::toDTOResponse).toList();
    }
}