package backend.dominio.puertos.in.materia;

import backend.dominio.modelo.Materia;

public interface RestaurarMateriaUseCase {
    Materia restaurarMateria(Long id);
}
