package backend.aplicacion.services.materia;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;

import java.util.List;

public interface MateriaService {

    MateriaResponseDTO registrar(RegistrarMateriaDTORequest request);
    MateriaResponseDTO buscarPorId(Long id);
    List<MateriaResponseDTO> listarTodasLasMaterias();
    MateriaResponseDTO actualizar(Long id, ModificarMateriaDTORequest request);
    MateriaResponseDTO eliminar(Long id);
    MateriaResponseDTO restaurar(Long id);
}
