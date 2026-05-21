package backend.Aplicacion.usecase.estudiante;

import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.estudiante.ActivarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.exceptions.GenericNoContentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivarEstudianteUseCase implements ActivarEstudiante {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    @Override
    public EstudianteModel activar(Long id) {
        EstudianteModel estudiante = estudianteRepositoryPort.buscarPorIdIncluyendoBorrados(id)
                .orElseThrow(() -> new GenericNoContentException("Estudiante no encontrado"));
        estudiante.setDeleteFecha(null);
        return estudianteRepositoryPort.actualizar(estudiante);
    }
}