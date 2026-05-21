package backend.infraestructura.repositorios;

import backend.infraestructura.entidades.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaEstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    List<EstudianteEntity> findByFechaBajaIsNull();

    List<EstudianteEntity> findByFechaBajaIsNotNull();
}