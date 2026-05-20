package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.dominio.modelo.Puntaje;
import backend.dominio.puertos.in.puntaje.RegistrarPuntajeUseCase;
import backend.dominio.puertos.out.puntaje.PuntajeModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPuntajeImpl implements RegistrarPuntajeUseCase {

    private final PuntajeModelPort puntajeModelPort;

    @Override
    public Puntaje ejecutar(RegistrarPuntajeDTORequest req){
        Puntaje puntaje = new Puntaje();
        puntaje.setValor(req.valor());

        validar(req.valor());

        return puntajeModelPort.guardar(puntaje, req.materiaId(), req.estudianteId());
    }

    private void validar(Double valor) {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 10");
        }
    }
}
