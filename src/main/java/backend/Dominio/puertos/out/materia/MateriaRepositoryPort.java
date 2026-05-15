package backend.Dominio.puertos.out.materia;

import backend.Dominio.modelo.MateriaModel;

import java.util.Optional;

public interface MateriaRepositoryPort {
    MateriaModel guardar(MateriaModel materia);
    Optional<MateriaModel>buscarPorId(Long id);
    Optional<MateriaModel> buscarActivaPorId(Long id);
}
