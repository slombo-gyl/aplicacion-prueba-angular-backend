package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.BajaEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BajaEstudianteUseCaseImpl implements BajaEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante bajaEstudianteUseCase(Long id) {
        return repository.borrar(id);
    }
}