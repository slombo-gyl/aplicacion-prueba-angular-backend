package backend.Aplicacion.usecase.puntaje.registrar;

import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPuntaje {

    private final PuntajeRepositoryPort puntajeRepositoryPort;

    public PuntajeModel ejecutar(RegistrarPuntajeDTORequest req){
        PuntajeModel puntaje = new PuntajeModel();
        puntaje.setValor(req.valor());

        validar(req.valor());

        return puntajeRepositoryPort.guardar(puntaje, req.materiaId(), req.estudianteId());
    }

    private void validar(Double valor) {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 10");
        }
    }
}
