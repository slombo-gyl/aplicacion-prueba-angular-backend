package backend.Aplicacion.usecase.puntaje;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import backend.Infraestructura.output.persistencia.repository.puntaje.PuntajeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ObtenerPuntaje {

    private final PuntajeRepositoryPort puntajeRepositoryPort;

    public ObtenerPuntajesDTOResponse ejecutar (){
        List<PuntajeModel> puntajes = puntajeRepositoryPort.listarTodos();

        List<String> labels = puntajes.stream()
                .map(p -> p.getMateria().getNombre())
                .collect(Collectors.toList());

        List<Integer> data = puntajes.stream()
                .map(p -> (int) p.getValor())
                .collect(Collectors.toList());

        return new ObtenerPuntajesDTOResponse(labels,data);
    }
}
