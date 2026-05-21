package backend.infraestructura.adapters;

import backend.dominio.modelo.Materia;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.entities.MateriaEntity;
import backend.infraestructura.mappers.MateriaDominioMapper;
import backend.infraestructura.repositories.MateriaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MateriaModelAdapter implements MateriaModelPort {

    private final MateriaJpaRepository materiaJpaRepository;
    private final MateriaDominioMapper materiaDominioMapper;

    @Override
    public Materia guardar(Materia materia) {
        MateriaEntity entityToSave = materiaDominioMapper.fromDominioModel(materia);

        MateriaEntity savedEntity = materiaJpaRepository.save(entityToSave);

        return materiaDominioMapper.toDominioModel(savedEntity);
    }

    @Override
    public Optional<Materia> buscarPorId(Long id) {
        return materiaJpaRepository.findById(id)
                .map(materiaDominioMapper::toDominioModel);
    }

    @Override
    public Optional<Materia> buscarActivaPorId(Long id) {
        return materiaJpaRepository.findByIdAndEstado(id, Estado.ACTIVO)
                .map(materiaDominioMapper::toDominioModel);
    }

    @Override
    public List<Materia> obtenerTodasLasMateriasActivas() {
        return materiaJpaRepository.findAllByEstado(Estado.ACTIVO).stream()
                .map(materiaDominioMapper::toDominioModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Materia> findByNombre(String nombre) {
        return materiaJpaRepository.findByNombre(nombre)
                .map(materiaDominioMapper::toDominioModel);
    }
}
