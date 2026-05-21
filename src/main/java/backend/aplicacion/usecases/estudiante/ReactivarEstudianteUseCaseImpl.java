package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.student.ReactivarEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReactivarEstudianteUseCaseImpl implements ReactivarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante reactivarEstudianteUseCase(Long id) {
        Estudiante estudiante = repository.obtenerInactivoPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado con id: " + id));

        estudiante.setEstado(Estado.ACTIVO);

        return repository.reactivar(estudiante);
    }
}