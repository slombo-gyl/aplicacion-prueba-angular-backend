package backend.infraestructura.repositories;

import backend.dominio.modelo.enums.Estado;
import backend.infraestructura.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstudianteJpaRepository extends JpaRepository<EstudianteEntity, Long> {
    List<EstudianteEntity> findAllByEstado(Estado estado);
    Optional<EstudianteEntity> findByIdAndEstado(Long id, Estado estado);
    Optional<EstudianteEntity> findByEmail(String email);
    Optional<EstudianteEntity> findByDni(String dni);
}