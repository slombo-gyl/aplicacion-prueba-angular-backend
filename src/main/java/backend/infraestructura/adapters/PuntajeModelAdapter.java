package backend.infraestructura.adapters;

import backend.dominio.modelo.Puntaje;
import backend.dominio.puertos.out.puntaje.PuntajeModelPort;
import backend.infraestructura.entities.PuntajeEntity;
import backend.infraestructura.mappers.PuntajeDominioMapper;
import backend.infraestructura.repositories.PuntajeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PuntajeModelAdapter implements PuntajeModelPort {

    private final PuntajeJpaRepository puntajeJpaRepository;
    private final PuntajeDominioMapper mapper;

    @Override
    public Puntaje guardar(Puntaje puntaje) {
        PuntajeEntity puntajeEntity = mapper.fromDominioModel(puntaje);
        PuntajeEntity guardado = puntajeJpaRepository.save(puntajeEntity);
        return mapper.toDominioModel(guardado);
    }

    @Override
    public List<Puntaje> obtenerPorEstudianteId(Long id) {
        return puntajeJpaRepository.findAllByEstudianteId(id)
                .stream()
                .map(mapper::toDominioModel)
                .toList();
    }
}