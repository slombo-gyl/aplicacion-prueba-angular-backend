package backend.Infraestructura.output.persistencia.adapater.materiaAdapter;

import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Dominio.modelo.Materia;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.out.materia.MateriaModelPort;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class MateriaRepositryAdapter implements MateriaModelPort {

    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public Materia guardar(Materia materia) {
        MateriaEntity entity = MateriaMapper.toEntity(materia);
        MateriaEntity saved = materiaJpaRepository.save(entity);

        return MateriaMapper.toModel(saved);

    }

    @Override
    public Optional<Materia> buscarPorId(Long id) {
        return materiaJpaRepository.findById(id)
                .map(MateriaMapper::toModel);
    }

    @Override
    public Optional<Materia> buscarActivaPorId(Long id) {
        return materiaJpaRepository.findByIdAndEstado(id, Estado.ACTIVO)
                .map(MateriaMapper::toModel);
    }

    @Override
    public List<Materia> obtenerTodasLasMateriasActivas() {
        return materiaJpaRepository.findAllByEstado(Estado.ACTIVO).
                stream().map(MateriaMapper::toModel).toList();
    }
}
