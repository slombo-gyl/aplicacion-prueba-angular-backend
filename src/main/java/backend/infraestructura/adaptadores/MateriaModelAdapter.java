package backend.infraestructura.adaptadores;

import backend.aplicacion.mappers.MateriaMapper;
import backend.dominio.modelos.MateriaModel;
import backend.infraestructura.entidades.MateriaEntity;
import backend.infraestructura.repositorios.JpaMateriaRepository;
import backend.dominio.puertos.out.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@AllArgsConstructor
public class MateriaModelAdapter implements MateriaModelPort {
    private final JpaMateriaRepository materiaJpaRepository;

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

    @Override
    public List<MateriaModel> listar(){
        return materiaJpaRepository.findAll()
                .stream()
                .map(MateriaMapper::toModel)
                .toList();
    }

    @Override
    public List<MateriaModel> listar(boolean activo){
        return activo ?
                materiaJpaRepository.findByFechaBajaIsNull()
                .stream()
                .map(MateriaMapper::toModel)
                .toList()
                :
                materiaJpaRepository.findByFechaBajaIsNotNull()
                .stream()
                .map(MateriaMapper::toModel)
                .toList();
    }
}