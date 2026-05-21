package backend.Aplicacion.usecase.estudiante;

import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.estudiante.BorrarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.exceptions.GenericNoContentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BorrarEstudianteUseCase implements BorrarEstudiante {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    @Override
    public EstudianteModel borrar(Long id) {
        EstudianteModel estudiante = estudianteRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new GenericNoContentException("Estudiante no encontrado"));
        estudiante.setDeleteFecha(LocalDateTime.now());
        return estudianteRepositoryPort.actualizar(estudiante);
    }
}