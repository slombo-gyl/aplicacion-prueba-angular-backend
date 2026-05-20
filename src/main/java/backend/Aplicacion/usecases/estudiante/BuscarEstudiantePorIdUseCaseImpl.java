package backend.Aplicacion.usecases.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.Dominio.puertos.in.Student.BuscarEstudiantePorIdUseCase;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.Infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarEstudiantePorIdUseCaseImpl implements BuscarEstudiantePorIdUseCase {

    private final EstudianteModelPort repository;

    @Override
    public EstudianteDTOResponse buscarEstudiantePorIdUseCase(Long id) {
        return repository.obtenerActivoPorId(id).map(EstudianteDTOMapper::toDTOResponse)
                .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));
    }
}
