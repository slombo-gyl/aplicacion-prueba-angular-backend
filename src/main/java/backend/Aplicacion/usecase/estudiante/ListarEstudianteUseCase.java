package backend.Aplicacion.usecase.estudiante;

import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.estudiante.ListarEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListarEstudianteUseCase implements ListarEstudiante {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    @Override
    public List<EstudianteModel> listarTodos() {
        return estudianteRepositoryPort.listarTodos();
    }

    @Override
    public Optional<EstudianteModel> buscarPorId(Long id) {
        return estudianteRepositoryPort.buscarPorId(id);
    }
}