package backend.aplicacion.usecases.materia;

import backend.dominio.modelo.Materia;
import backend.dominio.puertos.in.materia.ListarTodasLasMateriasUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarTodasLasMateriasUseCaseImpl implements ListarTodasLasMateriasUseCase {

    private final MateriaModelPort repository;

    @Override
    public List<Materia> listarTodasLasMaterias() {
        return repository.obtenerTodasLasMateriasActivas();
    }
}