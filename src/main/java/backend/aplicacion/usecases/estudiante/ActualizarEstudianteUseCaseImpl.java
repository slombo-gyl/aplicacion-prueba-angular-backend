package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.ActualizarEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import backend.infraestructura.exception.ValidacionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteUseCaseImpl implements ActualizarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante actualizarEstudianteUseCase(Long id, Estudiante estudiante) {
        Map<String, List<String>> errors = new HashMap<>();

        repository.findByEmail(estudiante.getEmail())
                .ifPresent(student -> errors.put("email", List.of("El email ya está registrado")));

        repository.findByDni(estudiante.getDni())
                .ifPresent(student -> errors.put("dni", List.of("El dni ya está registrado")));

        if (!errors.isEmpty()) {
            throw new ValidacionException(errors);
        }

        Estudiante estudianteExistente = repository.obtenerActivoPorId(id)
                .orElseThrow(() -> new NoEncontradoException("No se encontró un estudiante"));

        Optional.ofNullable(estudiante.getNombre()).ifPresent(estudianteExistente::setNombre);

        Optional.ofNullable(estudiante.getApellido()).ifPresent(estudianteExistente::setApellido);

        Optional.ofNullable(estudiante.getEmail()).ifPresent(estudianteExistente::setEmail);

        Optional.ofNullable(estudiante.getDni()).ifPresent(estudianteExistente::setDni);

        return repository.actualizar(estudianteExistente);
    }
}