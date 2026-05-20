package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.dominio.modelos.PuntajeModel;
import backend.dominio.puertos.out.PuntajeModelPort;
import backend.infraestructura.repositorios.JpaPuntajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObtenerPuntajesUseCase {
    private final PuntajeModelPort puntajeModelPort;

    public List<PuntajeDTOResponse> ejecutar(){
        return puntajeModelPort.listar()
                .stream()
                .map(puntajeModel -> new PuntajeDTOResponse
                        (
                                puntajeModel.getMateria().getNombre(),
                                (int)puntajeModel.getValor()
                        )
                )
                .collect(Collectors.toList());
//        List<PuntajeModel> puntajes = puntajeModelPort.listar();
//
//        List<String> materias = puntajes.stream()
//                .map(p -> p.getMateria().getNombre())
//                .collect(Collectors.toList());
//
//        List<Integer> nota = puntajes.stream()
//                .map(p -> (int) p.getValor())
//                .collect(Collectors.toList());
//
//        return new PuntajeDTOResponse(materias, nota);

    }
}