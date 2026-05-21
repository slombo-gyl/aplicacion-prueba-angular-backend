package backend.Aplicacion.usecase.materia;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.ListarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListarMateriaUseCase implements ListarMateria {

    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public List<MateriaModel> listarTodas() {
        return materiaRepositoryPort.listarTodas();
    }

    @Override
    public Optional<MateriaModel> buscarPorId(Long id) {
        return materiaRepositoryPort.buscarPorId(id);
    }

    @Override
    public Optional<MateriaModel> buscarPorNombre(String nombre) {
        return materiaRepositoryPort.buscarPorNombre(nombre);
    }
}
