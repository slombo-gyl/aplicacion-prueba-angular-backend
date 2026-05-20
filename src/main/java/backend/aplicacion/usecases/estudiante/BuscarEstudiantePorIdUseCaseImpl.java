package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.dominio.puertos.in.student.BuscarEstudiantePorIdUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.exception.NoEncontradoException;
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
