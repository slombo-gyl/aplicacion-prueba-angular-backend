package backend.Aplicacion.usecase.estudiante.actualizar;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteUseCase implements backend.Dominio.puertos.in.Student.ActualizarEstudianteUseCase {

    private final EstudianteModelPort repository;


    @Override
    public EstudianteDTOResponse ejecutar(Long id, ActualizarEstudianteDTORequest dto) {
        Estudiante estudiante = repository.obtenerPorId(id).
                orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));

        StudentMapper.updateModelFromDto(dto, estudiante);
        repository.guardar(estudiante);

        return StudentMapper.toDTOResponse(estudiante);
    }
}
