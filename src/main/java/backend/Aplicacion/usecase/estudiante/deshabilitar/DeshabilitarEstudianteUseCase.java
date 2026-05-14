package backend.Aplicacion.usecase.estudiante.deshabilitar;

import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.EstudianteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DeshabilitarEstudianteUseCase implements backend.Dominio.puertos.in.estudiante.DeshabilitarEstudiante {
    private final EstudianteJpaRepository repository;

    @Override
    public LocalDateTime ejecutar(Long id) {

        EstudianteEntity estudianteBuscado = repository.findById(id).orElseThrow(NoSuchElementException::new);

        estudianteBuscado.setFechaBaja(LocalDateTime.now());

        return LocalDateTime.now();
    }
}