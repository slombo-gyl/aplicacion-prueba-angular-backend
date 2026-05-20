package backend.Aplicacion.services.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;

public interface MateriaService {

    MateriaResponseDTO crear(RegistrarMateriaDTORequest request);


}
