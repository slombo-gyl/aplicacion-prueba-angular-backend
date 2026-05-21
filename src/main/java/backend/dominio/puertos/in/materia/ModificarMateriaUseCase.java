package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.dominio.modelo.Materia;

public interface ModificarMateriaUseCase {
    Materia actualizarMateria(Long id, ModificarMateriaDTORequest req);
}
