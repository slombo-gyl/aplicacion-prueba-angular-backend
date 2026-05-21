package backend.aplicacion.usecases.estudiante;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.ListarTodosLosEstudiantesUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodosLosEstudiantesUseCaseImpl implements ListarTodosLosEstudiantesUseCase {
    private final EstudianteModelPort repository;

    @Override
    public List<Estudiante> listarTodosLosEstudiantesUseCase() {
        return repository.obtenerTodosLosEstudiantesActivos();
    }
}