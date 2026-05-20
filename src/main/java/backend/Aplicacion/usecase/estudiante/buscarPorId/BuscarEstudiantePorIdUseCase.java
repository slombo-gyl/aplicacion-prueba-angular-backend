package backend.Aplicacion.usecase.estudiante.buscarPorId;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarEstudiantePorIdUseCase implements backend.Dominio.puertos.in.Student.BuscarEstudiantePorIdUseCase {

    private final EstudianteModelPort repository;

    @Override
    public EstudianteDTOResponse ejecutar(Long id) {
        return repository.obtenerActivoPorId(id).map(StudentMapper::toDTOResponse)
                .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));
    }
}
