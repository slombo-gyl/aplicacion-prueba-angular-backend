package backend.Aplicacion.services.materia.impl;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Aplicacion.services.materia.MateriaService;
import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.exceptions.GenericNoContentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MateriaServiceImpl implements MateriaService {

    private final MateriaModelService materiaModelService;
    private final MateriaMapper materiaMapper;

    @Override
    public MateriaResponseDTO create(MateriaDTORequest materiaDto) {
        MateriaModel materia = materiaMapper.toModel(materiaDto);
        materia.setInsertFecha(LocalDateTime.now());
        MateriaModel materiaGuardada = materiaModelService.guardar(materia);
        return materiaMapper.toResponseDto(materiaGuardada);
    }

    @Override
    public List<MateriaResponseDTO> getAll() {
        return materiaMapper.toResponseDtoList(materiaModelService.listarTodas());
    }

    @Override
    public MateriaResponseDTO getById(Long id) {
        return materiaModelService.buscarPorId(id)
                .map(materiaMapper::toResponseDto)
                .orElseThrow(() -> new GenericNoContentException("Materia no encontrada"));
    }

    @Override
    public MateriaResponseDTO getByName(String name) {
        return materiaModelService.buscarPorNombre(name)
                .map(materiaMapper::toResponseDto)
                .orElseThrow(() -> new GenericNoContentException("Materia no encontrada"));
    }

    @Override
    public MateriaResponseDTO update(Long materiaId, MateriaDTORequest materiaDtoToUpdate) {
        MateriaModel materia = materiaMapper.toModel(materiaDtoToUpdate);
        materia.setId(materiaId);
        MateriaModel materiaActualizada = materiaModelService.actualizar(materia);
        return materiaMapper.toResponseDto(materiaActualizada);
    }

    @Override
    public MateriaResponseDTO delete(Long id) {
        MateriaModel materiaBorrada = materiaModelService.borrado(id);
        materiaBorrada.setDeleteFecha(LocalDateTime.now());
        return materiaMapper.toResponseDto(materiaBorrada);
    }
}