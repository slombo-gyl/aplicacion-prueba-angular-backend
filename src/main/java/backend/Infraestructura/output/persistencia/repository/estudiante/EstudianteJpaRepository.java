package backend.Infraestructura.output.persistencia.repository.estudiante;

import backend.Dominio.modelo.enums.Estado;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteJpaRepository extends JpaRepository<EstudianteEntity, Long> {

    List<EstudianteEntity> findAllByEstado(Estado estado);
}