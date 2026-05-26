package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.aplicacion.mappers.PuntajeMapper;
import backend.dominio.puertos.in.puntaje.ObtenerListaPuntajesUseCase;
import backend.dominio.puertos.out.PuntajeModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerListaPuntajesUseCaseImpl implements ObtenerListaPuntajesUseCase {
    private final PuntajeModelPort repository;

    @Override
    public List<PuntajeDTOResponse> ejecutar() {
        return repository.listar()
                .stream()
                .map(PuntajeMapper::toResponseDto)
                .toList();
    }
}