package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.dominio.modelos.PuntajeModel;
import backend.dominio.puertos.out.PuntajeModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarPuntajeUseCase {
    private final PuntajeModelPort puntajeRepositoryPort;

    public PuntajeModel ejecutar(PuntajeDTORequest req){
        PuntajeModel puntaje = puntajeRepositoryPort.buscar(req.materiaId(), req.estudianteId());

        puntaje.setValor(req.valor());

        puntaje.validar();

        return puntajeRepositoryPort.guardar(puntaje, req.materiaId(), req.estudianteId());
    }
}