package backend.Aplicacion.usecase.estudiante.registrar;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarEstudianteUseCase implements backend.Dominio.puertos.in.Student.RegistrarEstudianteUseCase {

    private final EstudianteRepositoryPort repository;

    @Override
    public EstudianteDTOResponse ejecutar(RegistrarEstudianteDTORequest dto) {
        Estudiante estudiante = StudentMapper.dtoToModel(dto);

        Estudiante estudianteGuardado = repository.guardar(estudiante);

        return StudentMapper.toDTOResponse(estudianteGuardado);
    }
}
