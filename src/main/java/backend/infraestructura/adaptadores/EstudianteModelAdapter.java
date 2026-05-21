package backend.infraestructura.adaptadores;

import backend.aplicacion.mappers.EstudianteMapper;
import backend.dominio.modelos.EstudianteModel;
import backend.infraestructura.entidades.EstudianteEntity;
import backend.infraestructura.repositorios.JpaEstudianteRepository;
import backend.dominio.puertos.out.EstudianteModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@AllArgsConstructor
public class EstudianteModelAdapter implements EstudianteModelPort {
    private final JpaEstudianteRepository estudianteJpaRepository;

    @Override
    public EstudianteModel guardar(EstudianteModel student) {
        EstudianteEntity entity = EstudianteMapper.toEntity(student);
        EstudianteEntity saved = estudianteJpaRepository.save(entity);
        return EstudianteMapper.toModel(saved);
    }
    @Override
    public EstudianteModel buscarPorId(Long id) {
        return EstudianteMapper.toModel(estudianteJpaRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public List<EstudianteModel> listar(){
        return estudianteJpaRepository.findAll()
                .stream()
                .map(EstudianteMapper::toModel)
                .toList();
    }

    @Override
    public List<EstudianteModel> listar(boolean activo){
        return activo ?
                estudianteJpaRepository.findByFechaBajaIsNull()
                .stream()
                .map(EstudianteMapper::toModel)
                .toList()
                :
                estudianteJpaRepository.findByFechaBajaIsNotNull()
                .stream()
                .map(EstudianteMapper::toModel)
                .toList();
    }
}