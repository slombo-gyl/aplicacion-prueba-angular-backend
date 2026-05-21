package backend.Dominio.puertos.in.materia;

import backend.Dominio.modelo.MateriaModel;

import java.util.List;
import java.util.Optional;

public interface ListarMateria {
    List<MateriaModel> listarTodas();

    Optional<MateriaModel> buscarPorId(Long id);

    Optional<MateriaModel> buscarPorNombre(String nombre);
}
