package backend.Infraestructura.output.persistencia.adapter.puntajeAdapter;

import backend.Aplicacion.mapper.puntajeMapper.PuntajeMapper;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import backend.Infraestructura.excepciones.RecursoNoEncontradoException;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import backend.Infraestructura.output.persistencia.repository.puntaje.PuntajeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PuntajeAdapter implements PuntajeRepositoryPort {

    private final PuntajeJpaRepository puntajeJpaRepository;
    private final EstudianteJpaRepository estudianteJpaRepository;
    private final MateriaJpaRepository materiaJpaRepository;

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
