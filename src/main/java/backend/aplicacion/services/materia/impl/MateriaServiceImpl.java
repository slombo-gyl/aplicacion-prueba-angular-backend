package backend.aplicacion.services.materia.impl;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.aplicacion.mappers.materiaMapper.MateriaDTOMapper;
import backend.aplicacion.services.materia.MateriaService;
import backend.dominio.modelo.Materia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MateriaServiceImpl implements MateriaService {
    private final MateriaModelService materiaModelService;
    private final MateriaDTOMapper materiaDTOMapper;

    @Override
    public MateriaResponseDTO registrar(RegistrarMateriaDTORequest request) {
        Materia nuevaMateria = materiaModelService.registrarMateria(request);
        return materiaDTOMapper.toDto(nuevaMateria);
    }

    @Override
    public MateriaResponseDTO buscarPorId(Long id) {
        Materia materia = materiaModelService.buscarMateriaPorId(id);
        return materiaDTOMapper.toDto(materia);
    }

    @Override
    public List<MateriaResponseDTO> listarTodasLasMaterias() {
        List<Materia> materias = materiaModelService.listarTodasLasMaterias();
        return materiaDTOMapper.toDtoList(materias);
    }

    @Override
    public MateriaResponseDTO actualizar(Long id, ModificarMateriaDTORequest request) {
        Materia materiaActualizada = materiaModelService.actualizarMateria(id, request);
        return materiaDTOMapper.toDto(materiaActualizada);
    }

    @Override
    public MateriaResponseDTO eliminar(Long id) {
        Materia materiaEliminada = materiaModelService.eliminarMateria(id);
        return materiaDTOMapper.toDto(materiaEliminada);
    }

    @Override
    public MateriaResponseDTO restaurar(Long id) {
        Materia materiaRestaurada = materiaModelService.restaurarMateria(id);
        return materiaDTOMapper.toDto(materiaRestaurada);
    }
}