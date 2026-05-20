package backend.Infraestructura.repository;

import backend.dominio.modelo.enums.Estado;
import backend.Infraestructura.entitites.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstudianteJpaRepository extends JpaRepository<EstudianteEntity, Long> {

    List<EstudianteEntity> findAllByEstado(Estado estado);
    Optional<EstudianteEntity> findByIdAndEstado(Long id, Estado estado);
}