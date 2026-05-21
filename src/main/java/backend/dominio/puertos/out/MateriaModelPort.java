package backend.dominio.puertos.out;

import backend.dominio.modelos.MateriaModel;

import java.util.List;

public interface MateriaModelPort {
    MateriaModel guardar(MateriaModel materia);

    MateriaModel buscarPorId(Long id);

    List<MateriaModel> listar(boolean activo);

    List<MateriaModel> listar();
}