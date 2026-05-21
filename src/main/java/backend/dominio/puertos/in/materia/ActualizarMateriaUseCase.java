package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.MateriaDTORequest;
import backend.aplicacion.dto.materia.MateriaDTOResponse;

public interface ActualizarMateriaUseCase {MateriaDTOResponse ejecutar(Long Id, MateriaDTORequest req);}