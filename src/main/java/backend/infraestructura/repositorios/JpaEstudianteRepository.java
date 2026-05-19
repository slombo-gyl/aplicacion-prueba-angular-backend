package backend.infraestructura.repositorios;

import backend.infraestructura.entidades.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
}