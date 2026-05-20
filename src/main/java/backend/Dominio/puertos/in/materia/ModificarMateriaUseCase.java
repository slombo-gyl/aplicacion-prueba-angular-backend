package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.Aplicacion.dto.materia.ModificarMateriaDTOResponse;

public interface ModificarMateriaUseCase {
    ModificarMateriaDTOResponse ejecutar(Long id, ModificarMateriaDTORequest req);
}
