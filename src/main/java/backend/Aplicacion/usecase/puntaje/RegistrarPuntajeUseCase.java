package backend.Aplicacion.usecase.puntaje;

import backend.Aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.Aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.Aplicacion.mapper.puntajeMapper.PuntajeMapper;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.in.materia.RegistrarMateria;
import backend.Dominio.puertos.in.puntaje.RegistrarPuntaje;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPuntajeUseCase implements RegistrarPuntaje {

    private final PuntajeRepositoryPort puntajeRepositoryPort;

    @Override
    public PuntajeModel guardar(PuntajeModel puntajeModel, Long materiaId, Long estudianteId){ return puntajeRepositoryPort.
            guardar(puntajeModel, materiaId, estudianteId); }
}
