package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.MateriaNotasDTOResponse;
import backend.aplicacion.mappers.puntajeMapper.PuntajeDTOMapper;
import backend.dominio.modelo.Puntaje;
import backend.dominio.puertos.in.puntaje.ObtenerPuntajesPorEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.dominio.puertos.out.puntaje.PuntajeModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerPuntajesPorEstudianteUseCaseImpl implements ObtenerPuntajesPorEstudianteUseCase {
    private final PuntajeModelPort puntajeModelPort;
    private final EstudianteModelPort estudianteModelPort;
    private final PuntajeDTOMapper puntajeDTOMapper;

    @Override
    public List<MateriaNotasDTOResponse> ejecutar(Long id) {
       estudianteModelPort.obtenerActivoPorId(id)
                .orElseThrow(() -> new NoEncontradoException(
                        "No se ha encontrado el estudiante con el id " + id
                ));

        List<Puntaje> puntajes = puntajeModelPort.obtenerPorEstudianteId(id);

        return puntajeDTOMapper.toMateriaNotasDtoList(puntajes);
    }
}
