package backend.Aplicacion.usecase.estudiante.deshabilitar;

import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.estudiante.DeshabilitarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DeshabilitarEstudianteUseCase implements DeshabilitarEstudiante {
    private final EstudianteRepositoryPort repository;

    @Override
    public LocalDateTime ejecutar(Long id) {
        EstudianteModel estudianteBuscado = repository.buscarPorId(id);

        estudianteBuscado.setFechaBaja(LocalDateTime.now());

        repository.guardar(estudianteBuscado);

        return estudianteBuscado.getFechaBaja();
    }
}