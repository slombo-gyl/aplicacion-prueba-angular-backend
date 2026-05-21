package backend.Infraestructura.output.persistencia.repository.estudiante;

import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteJpaRepository extends JpaRepository<EstudianteEntity, Long> {

    Optional<EstudianteEntity> findByIdAndDeleteFechaIsNull(Long id);
    List<EstudianteEntity> findByDeleteFechaIsNull();
}