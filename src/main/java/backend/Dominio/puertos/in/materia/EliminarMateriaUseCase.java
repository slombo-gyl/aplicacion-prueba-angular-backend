package backend.Dominio.puertos.in.materia;

import backend.Dominio.modelo.Materia;

public interface EliminarMateriaUseCase {
    Materia ejecutar(Long id);
}
