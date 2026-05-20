package backend.dominio.puertos.in.puntaje;

import backend.aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.dominio.modelo.Puntaje;

public interface RegistrarPuntajeUseCase {
    Puntaje ejecutar(RegistrarPuntajeDTORequest dto);
}
