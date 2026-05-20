package backend.Aplicacion.usecases.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.Dominio.puertos.in.Student.ListarTodosLosEstudiantesUseCase;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
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