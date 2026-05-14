package backend.Aplicacion.usecase.estudiante.actualizar;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.Student.ActualizarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteUseCase implements ActualizarEstudiante {

    private final EstudianteRepositoryPort repository;


    @Override
    public EstudianteDTOResponse ejecutar(Long id, ActualizarEstudianteDTORequest dto) {
        EstudianteModel estudiante = repository.obtenerPorId(id).
                orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        StudentMapper.updateEntityFromDto(dto, estudiante);
        repository.guardar(estudiante);

        return StudentMapper.toDTOResponse(estudiante);
    }
}
