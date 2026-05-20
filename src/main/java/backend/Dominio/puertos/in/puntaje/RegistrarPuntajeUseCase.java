package backend.Dominio.puertos.in.puntaje;

import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Dominio.modelo.Puntaje;

public interface RegistrarPuntajeUseCase {
    Puntaje ejecutar(RegistrarPuntajeDTORequest dto);
}
