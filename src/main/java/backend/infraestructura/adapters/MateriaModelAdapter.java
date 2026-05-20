package backend.infraestructura.adapters;

import backend.dominio.modelo.Materia;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.entities.MateriaEntity;
import backend.infraestructura.mappers.MateriaDominioMapper;
import backend.infraestructura.repositories.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class MateriaModelAdapter implements MateriaModelPort {

    private final MateriaJpaRepository materiaJpaRepository;
    private final MateriaDominioMapper mapper;

    @Override
    public Materia guardar(Materia materia) {
        MateriaEntity materiaEntidad = mapper.fromDominioModel(materia);
        MateriaEntity materiaGuardada = materiaJpaRepository.save(materiaEntidad);

        return mapper.toDominioModel(materiaGuardada);

    }

    @Override
    public Optional<Materia> buscarPorId(Long id) {
        return materiaJpaRepository.findById(id)
                .map(mapper::toDominioModel);
    }

    @Override
    public Optional<Materia> buscarActivaPorId(Long id) {
        return materiaJpaRepository.findByIdAndEstado(id, Estado.ACTIVO)
                .map(mapper::toDominioModel);
    }

    @Override
    public List<Materia> obtenerTodasLasMateriasActivas() {
        return materiaJpaRepository.findAllByEstado(Estado.ACTIVO).
                stream().map(mapper::toDominioModel).toList();
    }
}
