package backend.Infraestructura.repository;

import backend.Infraestructura.entitites.PuntajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntajeJpaRepository extends JpaRepository<PuntajeEntity,Long> {
}
