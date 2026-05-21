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

        Estudiante estudianteExistente = repository.obtenerActivoPorId(id)
                .orElseThrow(() -> new NoEncontradoException("No se encontró un estudiante"));

        if (estudiante.getEmail() != null && !estudiante.getEmail().equals(estudianteExistente.getEmail())) {

            repository.findByEmail(estudiante.getEmail())
                    .ifPresent(e -> errors.put("email", List.of("ya existe")));
        }
        if (estudiante.getDni() != null && !estudiante.getDni().equals(estudianteExistente.getDni())) {

            repository.findByDni(estudiante.getDni())
                    .ifPresent(e -> errors.put("dni", List.of("ya existe")));
        }

        if (!errors.isEmpty()) {
            throw new ValidacionException(errors);
        }

        Optional.ofNullable(estudiante.getNombre()).ifPresent(estudianteExistente::setNombre);

        Optional.ofNullable(estudiante.getApellido()).ifPresent(estudianteExistente::setApellido);

        Optional.ofNullable(estudiante.getEmail()).ifPresent(estudianteExistente::setEmail);

        Optional.ofNullable(estudiante.getDni()).ifPresent(estudianteExistente::setDni);

        return repository.actualizar(estudianteExistente);
    }
}