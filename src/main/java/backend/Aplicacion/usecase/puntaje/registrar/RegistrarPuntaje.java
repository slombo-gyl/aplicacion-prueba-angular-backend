package backend.Aplicacion.usecase.puntaje.registrar;

import backend.Aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.Aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.Aplicacion.mapper.puntajeMapper.PuntajeMapper;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPuntaje {

    private final PuntajeRepositoryPort puntajeRepositoryPort;

    public PuntajeDTOResponse ejecutar(PuntajeDTORequest req){
        var puntaje = PuntajeMapper.toModel(req);
        puntaje.validar();

        var puntajeGuardado = puntajeRepositoryPort.guardar(puntaje, req.materiaId(), req.estudianteId());
        return PuntajeMapper.toResponseDto(puntajeGuardado);
    }
}
