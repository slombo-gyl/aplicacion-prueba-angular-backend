package backend.Dominio.puertos.in.materia;

import backend.Dominio.modelo.Materia;

public interface RestaurarMateria {
    Materia ejecutar(Long id);
}
