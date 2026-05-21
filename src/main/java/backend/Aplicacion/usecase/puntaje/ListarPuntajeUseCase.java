package backend.Aplicacion.usecase.puntaje;

import backend.Aplicacion.dto.puntaje.PuntajesDTOResponse;
import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.in.puntaje.ListarPuntaje;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import backend.Infraestructura.output.persistencia.repository.puntaje.PuntajeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListarPuntajeUseCase implements ListarPuntaje {

    private final PuntajeRepositoryPort puntajeRepository;

    @Override
    public List<PuntajeModel> buscarPorEstudiante(Long estudianteId){
        return puntajeRepository.buscarPorEstudiante(estudianteId);
    }

}
