package backend.Infraestructura.output.persistencia.adapter.materiaAdapter;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.mapper.materiaMapper.MateriaDominioMapper;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MateriaRepositryAdapter implements MateriaRepositoryPort {

    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public MateriaModel guardar(MateriaModel materia) {
        MateriaEntity entity = MateriaDominioMapper.toEntity(materia);
        entity.setInsertFecha(LocalDateTime.now());
        System.out.println(entity.getInsertFecha());
        MateriaEntity saved = materiaJpaRepository.save(entity);
        return MateriaDominioMapper.toModel(saved);
    }

    @Override
    public List<MateriaModel> listarTodas() {
        return materiaJpaRepository.findByActivoTrueAndDeleteFechaIsNull()
                .stream()
                .map(MateriaDominioMapper::toModel)
                .toList();
    }

    @Override
    public Optional<MateriaModel> buscarPorId(Long id) {
        return materiaJpaRepository.findByIdAndActivoTrueAndDeleteFechaIsNull(id)
                .map(MateriaDominioMapper::toModel);
    }

    @Override
    public Optional<MateriaModel> buscarPorNombre(String nombre) {
        return materiaJpaRepository.findByNombreAndActivoTrueAndDeleteFechaIsNull(nombre)
                .map(MateriaDominioMapper::toModel);
    }
}
