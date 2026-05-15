package backend.Dominio.puertos.out.materia;

import backend.Dominio.modelo.MateriaModel;

public interface MateriaRepositoryPort {
    MateriaModel guardar(MateriaModel materia);
    MateriaModel buscarPorId(Long id);
}