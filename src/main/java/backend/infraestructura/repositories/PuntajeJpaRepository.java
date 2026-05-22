package backend.infraestructura.repositories;

import backend.infraestructura.entities.PuntajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuntajeJpaRepository extends JpaRepository<PuntajeEntity,Long> {
    List<PuntajeEntity> findAllByEstudianteId(Long id);
    List<PuntajeEntity> findAllByMateriaId(Long materiaId);
}
