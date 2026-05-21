package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.RegistrarEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.exception.ValidacionException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RegistrarEstudianteUseCaseImpl implements RegistrarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante registrarEstudianteUseCase(Estudiante estudiante) {
        Map<String, List<String>> errors = new HashMap<>();

        repository.findByEmail(estudiante.getEmail())
                .ifPresent(student -> errors.put("email", List.of("El email ya está registrado")));

        repository.findByDni(estudiante.getDni())
                .ifPresent(student -> errors.put("dni", List.of("El dni ya está registrado")));

        if (!errors.isEmpty()) {
            throw new ValidacionException(errors);
        }

        return repository.guardar(estudiante);
    }
}