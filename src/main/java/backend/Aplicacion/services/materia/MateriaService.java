package backend.Aplicacion.services.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.dto.materia.MateriaDTORequest;

public interface MateriaService {

    MateriaResponseDTO crear(MateriaDTORequest request);


}
