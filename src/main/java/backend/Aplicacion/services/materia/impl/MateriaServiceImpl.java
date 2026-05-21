package backend.Aplicacion.services.materia.impl;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Aplicacion.services.materia.MateriaService;
import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.exceptions.GenericNoContentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@AllArgsConstructor
public class MateriaServiceImpl implements MateriaService {

    private final MateriaModelService materiaModelService;

    @Override
    public MateriaResponseDTO create(MateriaDTORequest materiaDto) {
        MateriaModel materia = MateriaMapper.toModel(materiaDto);
        materia.setInsertFecha(LocalDateTime.now());
        MateriaModel materiaGuardada = materiaModelService.guardar(materia);

        return MateriaMapper.toResponseDto(materiaGuardada);
    }

    @Override
    public List<MateriaResponseDTO> getAll() {
        return materiaModelService.listarTodas()
                .stream()
                .map(MateriaMapper::toResponseDto)
                .toList();
    }

    @Override
    public MateriaResponseDTO getById(Long id) {
        return materiaModelService.buscarPorId(id)
                .map(MateriaMapper::toResponseDto)
                .orElseThrow(() -> new GenericNoContentException("Materia no encontrada"));
    }

    @Override
    public MateriaResponseDTO getByName(String name) {
        return materiaModelService.buscarPorNombre(name)
                .map(MateriaMapper::toResponseDto)
                .orElseThrow(() -> new GenericNoContentException("Materia no encontrada"));
    }

    @Override
    public MateriaResponseDTO update(Long materiaId, MateriaDTORequest materiaDtoToUpdate) {
        MateriaModel materia = MateriaMapper.toModel(materiaDtoToUpdate);
        materia.setId(materiaId);

        MateriaModel materiaActualizada = materiaModelService.actualizar(materia);
        return MateriaMapper.toResponseDto(materiaActualizada);
    }

    @Override
    public MateriaResponseDTO delete(Long id) {
        MateriaModel materiaBorrada = materiaModelService.borrado(id);
        materiaBorrada.setDeleteFecha(LocalDateTime.now());
        return MateriaMapper.toResponseDto(materiaBorrada);
    }
}
