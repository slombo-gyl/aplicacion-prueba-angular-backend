package backend.Aplicacion.usecase.puntaje;

import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.in.puntaje.ActualizarPuntaje;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarPuntajeUseCase implements ActualizarPuntaje {

    private final PuntajeRepositoryPort puntajeRepositoryPort;

    @Override
    public PuntajeModel actualizar(PuntajeModel puntajeModel) {
        return puntajeRepositoryPort.actualizar(puntajeModel);
    }

}
