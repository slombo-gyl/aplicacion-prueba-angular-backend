package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.aplicacion.mappers.PuntajeMapper;
import backend.dominio.puertos.in.puntaje.ObtenerPuntajeSegunEstudianteYMateriaUseCase;
import backend.infraestructura.excepciones.RecursoNoEncontradoException;
import backend.infraestructura.repositorios.JpaEstudianteRepository;
import backend.infraestructura.repositorios.JpaMateriaRepository;
import backend.infraestructura.repositorios.JpaPuntajeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObtenerPuntajeSegunEstudianteYMateriaUseCaseImpl implements ObtenerPuntajeSegunEstudianteYMateriaUseCase {
    private JpaPuntajeRepository repository;
    private JpaEstudianteRepository estudianteRepository;
    private JpaMateriaRepository materiaRepository;

    @Override
    public PuntajeDTOResponse ejecutar(Long estudianteID, Long materiaID) {
        return PuntajeMapper.toResponseDto(PuntajeMapper.toModel(
                repository.findByEstudianteAndMateria
                (estudianteRepository.findById(estudianteID).orElseThrow(() -> new RecursoNoEncontradoException("No se encuentra Estudiante con ID: " + estudianteID))
                , materiaRepository.findById(materiaID).orElseThrow(() -> new RecursoNoEncontradoException("No se encuentra Materia con ID: "+ materiaID))
        )));
    }
}