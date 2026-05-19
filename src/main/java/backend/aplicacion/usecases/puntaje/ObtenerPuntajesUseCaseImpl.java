package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.infraestructura.repositorios.JpaPuntajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObtenerPuntajesUseCaseImpl {
    private final JpaPuntajeRepository puntajeJpaRepository;

    public PuntajeDTOResponse ejecutar(){
        var puntajes = puntajeJpaRepository.findAll();

        List<String> labels = puntajes.stream()
                .map(p -> p.getMateria().getNombre())
                .collect(Collectors.toList());

        List<Integer> data = puntajes.stream()
                .map(p -> (int) p.getValor())
                .collect(Collectors.toList());

        return new backend.aplicacion.dto.puntaje.PuntajeDTOResponse(labels,data);
    }
}