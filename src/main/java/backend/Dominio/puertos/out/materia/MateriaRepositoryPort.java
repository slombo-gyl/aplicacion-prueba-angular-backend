package backend.Dominio.puertos.out.materia;

import backend.Dominio.modelo.MateriaModel;

import java.util.List;
import java.util.Optional;

public interface MateriaRepositoryPort {
    MateriaModel guardar(MateriaModel materia);

    List<MateriaModel> listarTodas();

    Optional<MateriaModel> buscarPorId(Long id);

    Optional<MateriaModel> buscarPorNombre(String nombre);
}
