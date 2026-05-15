package backend.Aplicacion.usecase.estudiante.registrar;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.Student.RegistrarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarEstudianteUseCase implements RegistrarEstudiante {

    private final EstudianteRepositoryPort repository;

    @Override
    public EstudianteDTOResponse ejecutar(RegistrarEstudianteDTORequest dto) {
        EstudianteModel estudiante = StudentMapper.dtoToModel(dto);

        EstudianteModel estudianteGuardado = repository.guardar(estudiante);

        return StudentMapper.toDTOResponse(estudianteGuardado);
    }
}
