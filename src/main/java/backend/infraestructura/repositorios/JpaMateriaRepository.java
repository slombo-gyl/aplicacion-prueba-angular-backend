package backend.infraestructura.repositorios;

import backend.infraestructura.entidades.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMateriaRepository extends JpaRepository<MateriaEntity, Long> {
    List<MateriaEntity> findByFechaBajaIsNull();

    List<MateriaEntity> findByFechaBajaIsNotNull();
}