package backend.infraestructura.adaptadores;

import backend.aplicacion.mappers.PuntajeMapper;
import backend.dominio.modelos.PuntajeModel;
import backend.infraestructura.excepciones.RecursoNoEncontradoException;
import backend.infraestructura.entidades.EstudianteEntity;
import backend.infraestructura.entidades.MateriaEntity;
import backend.infraestructura.entidades.PuntajeEntity;
import backend.infraestructura.repositorios.JpaEstudianteRepository;
import backend.infraestructura.repositorios.JpaMateriaRepository;
import backend.infraestructura.repositorios.JpaPuntajeRepository;
import backend.dominio.puertos.out.PuntajeModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PuntajeModelAdapter implements PuntajeModelPort {

    private final JpaPuntajeRepository puntajeJpaRepository;
    private final JpaEstudianteRepository estudianteJpaRepository;
    private final JpaMateriaRepository materiaJpaRepository;

    @Override
    public PuntajeModel guardar(PuntajeModel puntaje, Long materiaId, Long estudianteId) {

        EstudianteEntity estudiante = estudianteJpaRepository.findById(estudianteId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estudiante con ID: "+ estudianteId +" no encontrado"));

        MateriaEntity materia = materiaJpaRepository.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia con ID: "+ materiaId +" no encontrada"));

        PuntajeEntity entity = PuntajeMapper.toEntity(puntaje, materia, estudiante);
        PuntajeEntity saved = puntajeJpaRepository.save(entity);

        return PuntajeMapper.toModel(saved);
    }
}
