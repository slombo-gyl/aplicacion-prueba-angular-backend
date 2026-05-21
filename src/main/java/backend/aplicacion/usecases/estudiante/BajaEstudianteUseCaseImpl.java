package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.student.BajaEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BajaEstudianteUseCaseImpl implements BajaEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante bajaEstudianteUseCase(Long id) {
        Estudiante estudiante = repository.obtenerActivoPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado con id: " + id));

        estudiante.setEstado(Estado.INACTIVO);

        return repository.borrar(estudiante);
    }
}