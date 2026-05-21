package backend.Infraestructura.output.persistencia.adapter.materiaAdapter;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.mapper.materiaMapper.MateriaDominioMapper;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class MateriaRepositryAdapter implements MateriaRepositoryPort {

    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public MateriaModel guardar(MateriaModel materia) {
        MateriaEntity entity = MateriaDominioMapper.toEntity(materia);
        MateriaEntity saved = materiaJpaRepository.save(entity);

        return MateriaDominioMapper.toModel(saved);

    }
}
