package backend.Aplicacion.usecase.estudiante;

import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.estudiante.ActualizarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActualizarEstudianteUseCase implements ActualizarEstudiante {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    @Override
    public EstudianteModel actualizar(EstudianteModel estudiante) {
        return estudianteRepositoryPort.actualizar(estudiante);
    }
}