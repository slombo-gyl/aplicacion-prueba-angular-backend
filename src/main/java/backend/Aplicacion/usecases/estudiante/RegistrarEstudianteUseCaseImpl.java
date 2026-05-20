package backend.Aplicacion.usecases.estudiante;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.puertos.in.Student.RegistrarEstudianteUseCase;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
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
