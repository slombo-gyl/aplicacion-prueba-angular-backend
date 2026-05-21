package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.ActualizarEstudianteUseCases;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteUseCaseImpl implements ActualizarEstudianteUseCases {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante actualizarEstudianteUseCase(Long id, Estudiante estudiante) {
        return repository.actualizar(id, estudiante);
    }
}