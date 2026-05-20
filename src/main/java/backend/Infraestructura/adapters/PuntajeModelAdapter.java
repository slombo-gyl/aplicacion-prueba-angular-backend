package backend.Infraestructura.adapters;

import backend.Aplicacion.mappers.puntajeMapper.PuntajeDTOMapper;
import backend.Dominio.modelo.Puntaje;
import backend.Dominio.puertos.out.puntaje.PuntajeModelPort;
import backend.Infraestructura.entitites.EstudianteEntity;
import backend.Infraestructura.entitites.MateriaEntity;
import backend.Infraestructura.entitites.PuntajeEntity;
import backend.Infraestructura.repository.EstudianteJpaRepository;
import backend.Infraestructura.repository.MateriaJpaRepository;
import backend.Infraestructura.repository.PuntajeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PuntajeModelAdapter implements PuntajeModelPort {

    private final PuntajeJpaRepository puntajeJpaRepository;
    private final EstudianteJpaRepository estudianteJpaRepository;
    private final MateriaJpaRepository materiaJpaRepository;

    @Override
    public Puntaje guardar(Puntaje puntaje, Long materiaId, Long estudianteId) {

        EstudianteEntity estudiante = estudianteJpaRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        MateriaEntity materia = materiaJpaRepository.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        PuntajeEntity entity = PuntajeDTOMapper.toEntity(puntaje, materia, estudiante);
        PuntajeEntity saved = puntajeJpaRepository.save(entity);

        return PuntajeDTOMapper.toModel(saved);
    }
}
