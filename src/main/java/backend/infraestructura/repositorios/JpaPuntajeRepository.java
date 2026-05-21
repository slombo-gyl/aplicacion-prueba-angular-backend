package backend.infraestructura.repositorios;

import backend.dominio.modelos.PuntajeModel;
import backend.infraestructura.entidades.EstudianteEntity;
import backend.infraestructura.entidades.MateriaEntity;
import backend.infraestructura.entidades.PuntajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPuntajeRepository extends JpaRepository<PuntajeEntity,Long> {
    boolean existsByEstudianteAndMateria(EstudianteEntity estudiante, MateriaEntity materia);
    PuntajeModel findByEstudianteAndMateria(EstudianteEntity estudiante, MateriaEntity materia);
    List<PuntajeEntity> findByFechaBajaIsNull();
    List<PuntajeEntity> findByFechaBajaIsNotNull();
}