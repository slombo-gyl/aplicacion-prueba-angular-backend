package backend.Infraestructura.output.persistencia.repository.puntaje;

import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntajeJpaRepository extends JpaRepository<PuntajeEntity,Long> {
    List<PuntajeEntity> findByEstudianteId (Long estudianteId);
}
