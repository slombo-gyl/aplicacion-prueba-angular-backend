package backend.Infraestructura.output.persistencia.repository.materia;

import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaJpaRepository extends JpaRepository<MateriaEntity, Long> {
    List<MateriaEntity> findByActivoTrue();

    Optional<MateriaEntity> findByIdAndActivoTrue(Long id);

    Optional<MateriaEntity> findByNombreAndActivoTrue(String nombre);
}
