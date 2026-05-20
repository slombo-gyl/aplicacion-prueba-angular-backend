package backend.infraestructura.repositories;

import backend.infraestructura.entities.PuntajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntajeJpaRepository extends JpaRepository<PuntajeEntity,Long> {
}
