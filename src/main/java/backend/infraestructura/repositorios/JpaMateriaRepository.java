package backend.infraestructura.repositorios;

import backend.infraestructura.entidades.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMateriaRepository extends JpaRepository<MateriaEntity, Long> {
}
