package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.RegistrarEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarEstudianteUseCaseImpl implements RegistrarEstudianteUseCase {

    private final EstudianteModelPort repository;

    @Override
    public EstudianteDTOResponse registrarEstudianteUseCase(RegistrarEstudianteDTORequest dto) {
        Estudiante estudiante = EstudianteDTOMapper.dtoToModel(dto);

        Estudiante estudianteGuardado = repository.guardar(estudiante);

        return EstudianteDTOMapper.toDTOResponse(estudianteGuardado);
    }
}
