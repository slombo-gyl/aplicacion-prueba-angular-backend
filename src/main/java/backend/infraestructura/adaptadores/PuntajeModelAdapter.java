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

import java.util.List;

@Repository
@AllArgsConstructor
public class PuntajeModelAdapter implements PuntajeModelPort {
    private final JpaPuntajeRepository puntajeJpaRepository;
    private final JpaEstudianteRepository estudianteJpaRepository;
    private final JpaMateriaRepository materiaJpaRepository;

    @Override
    public PuntajeModel guardar(PuntajeModel puntaje, Long materiaId, Long estudianteId) {
        EstudianteEntity estudiante = buscarEstudiante(estudianteId);
        MateriaEntity materia = buscarMateria(materiaId);

        PuntajeEntity entity = PuntajeMapper.toEntity(puntaje, materia, estudiante);
        PuntajeEntity saved = puntajeJpaRepository.save(entity);

        return PuntajeMapper.toModel(saved);
    }

    @Override
    public PuntajeModel buscar(Long id){
        return puntajeJpaRepository.findById(id)
                .map(PuntajeMapper::toModel)
                .orElseThrow(() -> new RecursoNoEncontradoException(id));
    }

    @Override
    public PuntajeModel buscar(Long materiaId, Long estudianteId){
        EstudianteEntity estudiante = buscarEstudiante(estudianteId);
        MateriaEntity materia = buscarMateria(materiaId);

        return PuntajeMapper.toModel(puntajeJpaRepository.findByEstudianteAndMateria(estudiante,materia));
    }

    @Override
    public List<PuntajeModel> listar() {
        return puntajeJpaRepository.findAll()
                .stream()
                .map(PuntajeMapper::toModel)
                .toList();
    }

    @Override
    public List<PuntajeModel> listarDeEstudiante(Long estudianteId) {
        return puntajeJpaRepository.findByEstudiante(
                estudianteJpaRepository.findById(estudianteId)
                        .orElseThrow(() -> new RecursoNoEncontradoException("No se encuentra estudiante con ID: " + estudianteId)))
                .stream()
                .map(PuntajeMapper::toModel)
                .toList();
    }


    @Override
    public boolean existePuntaje(Long materiaId, Long estudianteId){
        EstudianteEntity estudiante = buscarEstudiante(estudianteId);
        MateriaEntity materia = buscarMateria(materiaId);
        return puntajeJpaRepository.existsByEstudianteAndMateria(estudiante,materia);
    }

    private EstudianteEntity buscarEstudiante(Long estudianteId){
        return estudianteJpaRepository.findById(estudianteId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estudiante con ID: " + estudianteId + " no encontrado"));
    }

    private MateriaEntity buscarMateria(Long materiaId){
        return materiaJpaRepository.findById(materiaId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Materia con ID: " + materiaId + " no encontrado"));
    }
}