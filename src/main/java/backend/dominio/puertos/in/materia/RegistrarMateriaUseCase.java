package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;

public interface RegistrarMateriaUseCase {
MateriaResponseDTO ejecutar (RegistrarMateriaDTORequest req);
}
