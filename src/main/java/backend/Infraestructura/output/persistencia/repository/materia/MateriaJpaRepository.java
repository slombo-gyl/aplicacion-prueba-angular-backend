package backend.Infraestructura.output.persistencia.repository.materia;

import backend.Dominio.modelo.enums.Estado;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MateriaJpaRepository extends JpaRepository<MateriaEntity, Long> {
    Optional<MateriaEntity> findByIdAndEstado(Long id, Estado estado);
    List<MateriaEntity> findAllByEstado(Estado estado);
}
