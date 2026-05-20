package backend.Aplicacion.usecases.puntaje;

import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Dominio.modelo.Puntaje;
import backend.Dominio.puertos.out.puntaje.PuntajeModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPuntajeImpl {

    private final PuntajeModelPort puntajeModelPort;

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
