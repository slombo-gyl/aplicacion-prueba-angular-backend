package backend.infraestructura.adapters;

import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.entities.EstudianteEntity;
import backend.infraestructura.mappers.EstudianteDominioMapper;
import backend.infraestructura.repositories.EstudianteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

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
    public Optional<Estudiante> obtenerInactivoPorId(Long id) {
        return estudianteJpaRepository.findByIdAndEstado(id,Estado.INACTIVO)
                .map(mapper::toDominioModel);
    }

    @Override
    public Page<Estudiante> obtenerTodosLosEstudiantesActivos(Pageable pageable) {
        return estudianteJpaRepository.findAllByEstado(Estado.ACTIVO,pageable)
                .map(mapper::toDominioModel);
    }

    @Override
    public Optional<Estudiante> obtenerActivoPorId(Long id) {
        return estudianteJpaRepository.findByIdAndEstado(id,Estado.ACTIVO)
                .map(mapper::toDominioModel);
    }

    @Override
    public Estudiante actualizar(Estudiante estudiante) {
        EstudianteEntity estudianteEntidad = mapper.fromDominioModel(estudiante);
        EstudianteEntity estudianteGuardado = estudianteJpaRepository.save(estudianteEntidad);
        return mapper.toDominioModel(estudianteGuardado);
    }

    @Override
    public Estudiante borrar(Estudiante estudiante) {

        EstudianteEntity estudianteBorrado = estudianteJpaRepository.save(mapper.fromDominioModel(estudiante));

        return mapper.toDominioModel(estudianteBorrado);
    }

    @Override
    public Estudiante reactivar(Estudiante estudiante) {

        EstudianteEntity estudianteReactivado = estudianteJpaRepository.save(mapper.fromDominioModel(estudiante));

        return mapper.toDominioModel(estudianteReactivado);
    }

    @Override
    public Optional<Estudiante> findByEmail(String email) {
        return estudianteJpaRepository.findByEmail(email)
                .map(mapper::toDominioModel);
    }

    @Override
    public Optional<Estudiante> findByDni(String dni) {
        return estudianteJpaRepository.findByDni(dni)
                .map(mapper::toDominioModel);
    }
}