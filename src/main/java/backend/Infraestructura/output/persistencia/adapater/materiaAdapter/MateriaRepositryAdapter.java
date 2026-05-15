package backend.Infraestructura.output.persistencia.adapater.materiaAdapter;

import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class MateriaRepositryAdapter implements MateriaRepositoryPort {

    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public MateriaModel guardar(MateriaModel materia) {
        MateriaEntity entity = MateriaMapper.toEntity(materia);
        MateriaEntity saved = materiaJpaRepository.save(entity);

        return MateriaMapper.toModel(saved);

    }

    @Override
    public Optional<MateriaModel> buscarPorId(Long id) {
        return materiaJpaRepository.findById(id)
                .map(MateriaMapper::toModel);
    }

    @Override
    public Optional<MateriaModel> buscarActivaPorId(Long id) {
        return materiaJpaRepository.findByIdAndEstado(id, Estado.ACTIVO)
                .map(MateriaMapper::toModel);
    }

    @Override
    public List<MateriaModel> obtenerTodasLasMateriasActivas() {
        return materiaJpaRepository.findAllByEstado(Estado.ACTIVO).
                stream().map(MateriaMapper::toModel).toList();
    }
}
