package backend.Aplicacion.usecase.puntaje.obtener;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Infraestructura.output.persistencia.repository.puntaje.PuntajeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObtenerPuntajesUseCase {
    private final PuntajeJpaRepository puntajeJpaRepository;

    public ObtenerPuntajesDTOResponse ejecutar(){
        var puntajes = puntajeJpaRepository.findAll();

        List<String> labels = puntajes.stream()
                .map(p -> p.getMateria().getNombre())
                .collect(Collectors.toList());

        List<Integer> data = puntajes.stream()
                .map(p -> (int) p.getValor())
                .collect(Collectors.toList());

        return new ObtenerPuntajesDTOResponse(labels,data);
    }
}