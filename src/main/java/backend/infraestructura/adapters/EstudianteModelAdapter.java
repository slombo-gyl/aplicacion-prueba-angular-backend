package backend.infraestructura.adapters;

import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.entities.EstudianteEntity;
import backend.infraestructura.mappers.EstudianteDominioMapper;
import backend.infraestructura.repositories.EstudianteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EstudianteModelAdapter implements EstudianteModelPort {

    private final EstudianteJpaRepository estudianteJpaRepository;
    private final EstudianteDominioMapper mapper;

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        EstudianteEntity estudianteEntidad = mapper.fromDominioModel(estudiante);
        EstudianteEntity estudianteGuardado = estudianteJpaRepository.save(estudianteEntidad);
        return mapper.toDominioModel(estudianteGuardado);
    }

    @Override
    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteJpaRepository.findById(id).
                map(mapper::toDominioModel);
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantesActivos() {
        return estudianteJpaRepository.findAllByEstado(Estado.ACTIVO).
                stream().map(mapper::toDominioModel).toList();
    }

    @Override
    public Optional<Estudiante> obtenerActivoPorId(Long id) {
        return estudianteJpaRepository.findByIdAndEstado(id,Estado.ACTIVO)
                .map(mapper::toDominioModel);
    }


}
