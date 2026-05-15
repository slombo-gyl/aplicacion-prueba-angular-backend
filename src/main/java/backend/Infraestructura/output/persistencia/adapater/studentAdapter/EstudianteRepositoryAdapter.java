package backend.Infraestructura.output.persistencia.adapater.studentAdapter;

import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EstudianteRepositoryAdapter implements EstudianteRepositoryPort {

    private final EstudianteJpaRepository estudianteJpaRepository;

    @Override
    public EstudianteModel guardar(EstudianteModel student) {
        EstudianteEntity entity = StudentMapper.toEntity(student);
        EstudianteEntity saved = estudianteJpaRepository.save(entity);
        return StudentMapper.toModel(saved);
    }

    @Override
    public Optional<EstudianteModel> obtenerPorId(Long id) {
        return estudianteJpaRepository.findById(id).
                map(StudentMapper::toModel);
    }

    @Override
    public List<EstudianteModel> obtenerTodosLosEstudiantesActivos() {
        return estudianteJpaRepository.findAllByEstado(Estado.ACTIVO).
                stream().map(StudentMapper::toModel).toList();
    }

    @Override
    public Optional<EstudianteModel> obtenerActivoPorId(Long id) {
        return estudianteJpaRepository.findByIdAndEstado(id,Estado.ACTIVO)
                .map(StudentMapper::toModel);
    }


}
