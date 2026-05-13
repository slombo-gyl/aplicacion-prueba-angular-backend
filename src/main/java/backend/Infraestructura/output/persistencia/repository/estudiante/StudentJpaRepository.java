package backend.Infraestructura.output.persistencia.repository.estudiante;

import backend.Infraestructura.output.persistencia.entity.estudiante.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository  extends JpaRepository<StudentEntity, Long> {
}