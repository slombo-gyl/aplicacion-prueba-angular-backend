package backend.Aplicacion.services.materia;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaResponseDTO;

import java.util.List;

public interface MateriaService {

    MateriaResponseDTO create(MateriaDTORequest materiaDto);

    List<MateriaResponseDTO> getAll();

    MateriaResponseDTO getById(Long id);

    MateriaResponseDTO getByName(String name);

    MateriaResponseDTO update(Long materiaId, MateriaDTORequest materiaDtoToUpdate);

    MateriaResponseDTO delete(Long id);
}
