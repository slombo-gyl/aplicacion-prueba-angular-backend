package backend.Infraestructura.output.persistencia.adapter.materiaAdapter;

import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@AllArgsConstructor
public class MateriaRepositoryAdapter implements MateriaRepositoryPort {
    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public MateriaModel guardar(MateriaModel materia) {
        MateriaEntity entity = MateriaMapper.toEntity(materia);
        MateriaEntity saved = materiaJpaRepository.save(entity);

        return MateriaMapper.toModel(saved);
    }

    @Override
    public MateriaModel buscarPorId(Long id){
        return MateriaMapper.toModel(materiaJpaRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }
}