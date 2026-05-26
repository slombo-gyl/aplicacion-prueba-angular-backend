package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.aplicacion.mappers.PuntajeMapper;
import backend.dominio.modelos.PuntajeModel;
import backend.dominio.puertos.out.PuntajeModelPort;
import backend.infraestructura.excepciones.RecursoDuplicadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPuntajeUseCase {
    private final PuntajeModelPort puntajeRepositoryPort;

    public PuntajeDTOResponse ejecutar(PuntajeDTORequest req){
        if (yaExiste(req)){
            throw new RecursoDuplicadoException("Este puntaje ya está cargado, utiliza el método PUT para modificarlo");
        }

        PuntajeModel puntaje = new PuntajeModel();

        puntaje.setValor(req.valor());

        puntaje.validar();

        return PuntajeMapper.toResponseDto(
                puntajeRepositoryPort.guardar(puntaje, req.materiaId(), req.estudianteId())
                );
    }

    private boolean yaExiste(PuntajeDTORequest req){
        return puntajeRepositoryPort.existePuntaje(req.materiaId(), req.estudianteId());
    }
}