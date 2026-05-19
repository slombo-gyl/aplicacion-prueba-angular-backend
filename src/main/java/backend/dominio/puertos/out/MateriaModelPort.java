package backend.dominio.puertos.out;

import backend.dominio.modelos.MateriaModel;

public interface MateriaModelPort {
    MateriaModel guardar(MateriaModel materia);
    MateriaModel buscarPorId(Long id);
}