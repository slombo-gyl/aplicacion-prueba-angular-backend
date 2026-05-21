package backend.Infraestructura.output.persistencia.adapter.studentAdapter;

import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.mapper.estudianteMapper.EstudianteDominioMapper;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

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


}
