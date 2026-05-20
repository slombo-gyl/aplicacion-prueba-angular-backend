package backend.infraestructura.adapters;

import backend.aplicacion.mappers.puntajeMapper.PuntajeDTOMapper;
import backend.dominio.modelo.Puntaje;
import backend.dominio.puertos.out.puntaje.PuntajeModelPort;
import backend.infraestructura.entities.EstudianteEntity;
import backend.infraestructura.entities.MateriaEntity;
import backend.infraestructura.entities.PuntajeEntity;
import backend.infraestructura.repositories.EstudianteJpaRepository;
import backend.infraestructura.repositories.MateriaJpaRepository;
import backend.infraestructura.repositories.PuntajeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PuntajeModelAdapter implements PuntajeModelPort {

    private final PuntajeJpaRepository puntajeJpaRepository;
    private final EstudianteJpaRepository estudianteJpaRepository;
    private final MateriaJpaRepository materiaJpaRepository;
    private final PuntajeDTOMapper mapper;

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
