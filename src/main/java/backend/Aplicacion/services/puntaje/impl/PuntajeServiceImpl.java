package backend.Aplicacion.services.puntaje.impl;

import backend.Aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.Aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.Aplicacion.mapper.puntajeMapper.PuntajeMapper;
import backend.Aplicacion.services.puntaje.PuntajeService;
import backend.Dominio.modelo.PuntajeModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@AllArgsConstructor
public class PuntajeServiceImpl implements PuntajeService {

    private final PuntajeModelService puntajeModelService;
    private final PuntajeMapper puntajeMapper;

    @Override
    public PuntajeDTOResponse create(PuntajeDTORequest puntajeDto) {
        PuntajeModel puntaje = puntajeMapper.toModel(puntajeDto);
        PuntajeModel puntajeGuardado = puntajeModelService.guardar(
                puntaje,
                puntajeDto.materiaId(),
                puntajeDto.estudianteId()
        );
        puntajeGuardado.setInsertFecha(LocalDateTime.now());
        return puntajeMapper.toResponseDto(puntajeGuardado);
    }

    @Override
    public List<PuntajeDTOResponse> listarTodos() {
        return puntajeModelService.listarTodos()
                .stream()
                .map(puntajeMapper::toResponseDto)
                .toList();
    }

    @Override
    public PuntajeDTOResponse update(Long puntajeId, PuntajeDTORequest puntajeDtoToUpdate) {
        PuntajeModel puntaje = puntajeMapper.toModel(puntajeDtoToUpdate);
        puntaje.setId(puntajeId);

        PuntajeModel puntajeActualizado = puntajeModelService.actualizar(puntaje);
        return puntajeMapper.toResponseDto(puntajeActualizado);
    }
}