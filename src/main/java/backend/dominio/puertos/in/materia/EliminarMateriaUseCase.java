package backend.dominio.puertos.in.materia;

import backend.dominio.modelo.Materia;

public interface EliminarMateriaUseCase {
    Materia ejecutar(Long id);
}
