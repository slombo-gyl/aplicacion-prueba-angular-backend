package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.aplicacion.dto.materia.ModificarMateriaDTOResponse;

public interface ModificarMateriaUseCase {
    ModificarMateriaDTOResponse ejecutar(Long id, ModificarMateriaDTORequest req);
}
