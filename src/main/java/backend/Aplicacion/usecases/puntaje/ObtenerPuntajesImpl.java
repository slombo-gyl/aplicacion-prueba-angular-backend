package backend.Aplicacion.usecases.puntaje;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;
import backend.Infraestructura.output.persistencia.repository.puntaje.PuntajeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObtenerPuntajesImpl {

    private final PuntajeJpaRepository puntajeJpaRepository;

    public ObtenerPuntajesDTOResponse ejecutar(){
        var puntajes = puntajeJpaRepository.findAll();

        List<String> labels = puntajes.stream()
                .map(p -> p.getMateria().getNombre())
                .collect(Collectors.toList());

        List<Double> data = puntajes.stream()
                .map(PuntajeEntity::getValor)
                .collect(Collectors.toList());

        return new ObtenerPuntajesDTOResponse(labels,data);
    }

}
