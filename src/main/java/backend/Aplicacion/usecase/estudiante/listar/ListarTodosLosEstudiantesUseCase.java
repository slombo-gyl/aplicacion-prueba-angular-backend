package backend.Aplicacion.usecase.estudiante.listar;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodosLosEstudiantesUseCase implements backend.Dominio.puertos.in.Student.ListarTodosLosEstudiantesUseCase {

    private final EstudianteRepositoryPort repository;

    @Override
    public List<EstudianteDTOResponse> ejecutar() {
        return repository.obtenerTodosLosEstudiantesActivos().
                stream().map(StudentMapper::toDTOResponse).toList();
    }
}