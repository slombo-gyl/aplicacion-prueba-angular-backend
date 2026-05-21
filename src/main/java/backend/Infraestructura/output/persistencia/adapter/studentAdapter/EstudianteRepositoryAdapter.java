package backend.Infraestructura.output.persistencia.adapter.studentAdapter;

import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.mapper.estudianteMapper.EstudianteDominioMapper;
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
        EstudianteEntity entity = EstudianteDominioMapper.toEntity(student);
        EstudianteEntity saved = estudianteJpaRepository.save(entity);
        return EstudianteDominioMapper.toModel(saved);
    }

    @Override
    public List<EstudianteModel> listarTodos() {
        return estudianteJpaRepository.findByDeleteFechaIsNull()
                .stream()
                .map(EstudianteDominioMapper::toModel)
                .toList();
    }

    @Override
    public Optional<EstudianteModel> buscarPorId(Long id) {
        return estudianteJpaRepository.findByIdAndDeleteFechaIsNull(id)
                .map(EstudianteDominioMapper::toModel);
    }


    @Override
    public EstudianteModel actualizar(EstudianteModel estudiante) {
        EstudianteEntity entity = EstudianteDominioMapper.toEntity(estudiante);
        EstudianteEntity saved = estudianteJpaRepository.save(entity);
        return EstudianteDominioMapper.toModel(saved);
    }


    @Override
    public EstudianteModel borrar(Long id) {
        return null;
    }


    @Override
    public Optional<EstudianteModel> buscarPorIdIncluyendoBorrados(Long id) {
        return estudianteJpaRepository.findById(id)
                .map(EstudianteDominioMapper::toModel);
    }


}
