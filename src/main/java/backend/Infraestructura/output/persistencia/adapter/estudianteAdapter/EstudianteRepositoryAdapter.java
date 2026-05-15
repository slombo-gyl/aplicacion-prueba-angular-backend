package backend.Infraestructura.output.persistencia.adapter.estudianteAdapter;

import backend.Aplicacion.mapper.estudianteMapper.EstudianteMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@AllArgsConstructor
public class EstudianteRepositoryAdapter implements EstudianteRepositoryPort {
    private final EstudianteJpaRepository estudianteJpaRepository;

    @Override
    public EstudianteModel guardar(EstudianteModel student) {
        EstudianteEntity entity = EstudianteMapper.toEntity(student);
        EstudianteEntity saved = estudianteJpaRepository.save(entity);
        return EstudianteMapper.toModel(saved);
    }
    @Override
    public EstudianteModel buscarPorId(Long id) {
        return EstudianteMapper.toModel(estudianteJpaRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }
}