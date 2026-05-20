package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;

public interface RegistrarMateriaUseCase {
MateriaResponseDTO ejecutar (RegistrarMateriaDTORequest req);
}
