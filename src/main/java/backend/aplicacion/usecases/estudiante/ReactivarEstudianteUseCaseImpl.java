package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.ReactivarEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReactivarEstudianteUseCaseImpl implements ReactivarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante reactivarEstudianteUseCase(Long id) {
        return repository.reactivarPorId(id);
    }
}