package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.aplicacion.mappers.PuntajeMapper;
import backend.dominio.puertos.in.puntaje.ObtenerPuntajesDeEstudianteUseCase;
import backend.dominio.puertos.out.PuntajeModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerPuntajesDeEstudianteUseCaseImpl implements ObtenerPuntajesDeEstudianteUseCase {
    private final PuntajeModelPort repository;

    @Override
    public List<PuntajeDTOResponse> ejecutar(Long EstudianteID) {
        return repository.listarDeEstudiante(EstudianteID)
                .stream()
                .map(PuntajeMapper::toResponseDto)
                .toList();
    }
}