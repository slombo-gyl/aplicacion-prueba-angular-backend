package backend.Infraestructura.adapters;

import backend.Aplicacion.mappers.materiaMapper.MateriaDTOMapper;
import backend.Dominio.modelo.Materia;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.out.materia.MateriaModelPort;
import backend.Infraestructura.entitites.MateriaEntity;
import backend.Infraestructura.repository.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class MateriaModelAdapter implements MateriaModelPort {

    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public Materia guardar(Materia materia) {
        MateriaEntity entity = MateriaDTOMapper.toEntity(materia);
        MateriaEntity saved = materiaJpaRepository.save(entity);

        return MateriaDTOMapper.toModel(saved);

    }

    @Override
    public Optional<Materia> buscarPorId(Long id) {
        return materiaJpaRepository.findById(id)
                .map(MateriaDTOMapper::toModel);
    }

    @Override
    public Optional<Materia> buscarActivaPorId(Long id) {
        return materiaJpaRepository.findByIdAndEstado(id, Estado.ACTIVO)
                .map(MateriaDTOMapper::toModel);
    }

    @Override
    public List<Materia> obtenerTodasLasMateriasActivas() {
        return materiaJpaRepository.findAllByEstado(Estado.ACTIVO).
                stream().map(MateriaDTOMapper::toModel).toList();
    }
}
