package backend.Dominio.puertos.in.materia;

import backend.Dominio.modelo.MateriaModel;

public interface RestaurarMateria {
    MateriaModel ejecutar(Long id);
}
