package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.RegistrarEstudianteUseCases;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarEstudianteUseCaseImpl implements RegistrarEstudianteUseCases {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante registrarEstudianteUseCase(Estudiante estudiante) {
        return repository.guardar(estudiante);
    }
}