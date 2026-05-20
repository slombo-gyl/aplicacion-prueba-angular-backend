package backend.Infraestructura.output.persistencia.adapater.studentAdapter;

import backend.Aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EstudianteRepositoryAdapter implements EstudianteModelPort {

    private final EstudianteJpaRepository estudianteJpaRepository;

    @Override
    public Estudiante guardar(Estudiante student) {
        EstudianteEntity entity = EstudianteDTOMapper.toEntity(student);
        EstudianteEntity saved = estudianteJpaRepository.save(entity);
        return EstudianteDTOMapper.toModel(saved);
    }

    @Override
    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteJpaRepository.findById(id).
                map(EstudianteDTOMapper::toModel);
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantesActivos() {
        return estudianteJpaRepository.findAllByEstado(Estado.ACTIVO).
                stream().map(EstudianteDTOMapper::toModel).toList();
    }

    @Override
    public Optional<Estudiante> obtenerActivoPorId(Long id) {
        return estudianteJpaRepository.findByIdAndEstado(id,Estado.ACTIVO)
                .map(EstudianteDTOMapper::toModel);
    }


}
