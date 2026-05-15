package backend.Aplicacion.usecase.estudiante.buscarPorId;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.puertos.in.Student.BuscarEstudiantePorId;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarEstudiantePorIdUseCase implements BuscarEstudiantePorId {

    private final EstudianteRepositoryPort repository;

    @Override
    public EstudianteDTOResponse ejecutar(Long id) {
        return repository.obtenerActivoPorId(id).map(StudentMapper::toDTOResponse)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
}
