package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelos.EstudianteModel;
import backend.dominio.puertos.in.estudiante.DeshabilitarEstudianteUseCase;
import backend.dominio.puertos.out.EstudianteModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DeshabilitarEstudianteUseCaseImpl implements DeshabilitarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public LocalDateTime ejecutar(Long id) {
        EstudianteModel estudianteBuscado = repository.buscarPorId(id);

        estudianteBuscado.setFechaBaja(LocalDateTime.now());

        repository.guardar(estudianteBuscado);

        return estudianteBuscado.getFechaBaja();
    }
}