package backend.Dominio.puertos.in.materia;

import backend.Dominio.modelo.Materia;

public interface RestaurarMateriaUseCase {
    Materia ejecutar(Long id);
}
