package backend.infraestructura.repositories;

import backend.dominio.modelo.enums.Estado;
import backend.infraestructura.entities.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MateriaJpaRepository extends JpaRepository<MateriaEntity, Long> {
    Optional<MateriaEntity> findByIdAndEstado(Long id, Estado estado);
    List<MateriaEntity> findAllByEstado(Estado estado);
    Optional<MateriaEntity> findByNombre(String nombre);
}
