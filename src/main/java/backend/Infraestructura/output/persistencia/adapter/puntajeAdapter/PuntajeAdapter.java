package backend.Infraestructura.output.persistencia.adapter.puntajeAdapter;


import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import backend.Infraestructura.exceptions.GenericErrorException;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import backend.Infraestructura.output.persistencia.mapper.puntajeMapper.PuntajeDominioMapper;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import backend.Infraestructura.output.persistencia.repository.puntaje.PuntajeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class PuntajeAdapter implements PuntajeRepositoryPort {

    private final PuntajeJpaRepository puntajeJpaRepository;
    private final EstudianteJpaRepository estudianteJpaRepository;
    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public PuntajeModel guardar(PuntajeModel puntaje, Long materiaId, Long estudianteId) {

        EstudianteEntity estudiante = estudianteJpaRepository.findById(estudianteId)
                .orElseThrow(() -> new GenericErrorException("Estudiante no encontrado"));

        MateriaEntity materia = materiaJpaRepository.findById(materiaId)
                .orElseThrow(() -> new GenericErrorException("Materia no encontrada"));

        PuntajeEntity entity = PuntajeDominioMapper.toEntity(puntaje, materia, estudiante);
        entity.setInsertFecha(LocalDateTime.now());
        PuntajeEntity saved = puntajeJpaRepository.save(entity);

        return PuntajeDominioMapper.toModel(saved);
    }

    @Override
    public List<PuntajeModel> listarTodos() {
        return puntajeJpaRepository.findAll().
                stream().
                map(PuntajeDominioMapper::toModel).
                toList();
    }

    @Override
    public PuntajeModel actualizar(PuntajeModel puntaje) {
        PuntajeEntity puntajeExistente = puntajeJpaRepository.findById(puntaje.getId())
                .orElseThrow(() -> new GenericErrorException("Puntaje no encontrado"));

        EstudianteEntity estudiante = estudianteJpaRepository.findById(puntaje.getEstudiante().getId())
                .orElseThrow(() -> new GenericErrorException("Estudiante no encontrado"));

        MateriaEntity materia = materiaJpaRepository.findById(puntaje.getMateria().getId())
                .orElseThrow(() -> new GenericErrorException("Materia no encontrada"));

        puntajeExistente.setValor(puntaje.getValor());
        puntajeExistente.setEstudiante(estudiante);
        puntajeExistente.setMateria(materia);

        PuntajeEntity saved = puntajeJpaRepository.save(puntajeExistente);
        return PuntajeDominioMapper.toModel(saved);
    }
}
