package backend.infraestructura.repositorios;

import backend.infraestructura.entidades.PuntajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPuntajeRepository extends JpaRepository<PuntajeEntity,Long> {}