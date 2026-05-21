package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.BuscarEstudiantePorIdUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarEstudiantePorIdUseCaseImpl implements BuscarEstudiantePorIdUseCase {
    private final EstudianteModelPort repository;

    @Override
    public Estudiante buscarEstudiantePorIdUseCase(Long id) {
        return repository.obtenerActivoPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));
    }
}