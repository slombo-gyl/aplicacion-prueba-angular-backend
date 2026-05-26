package backend.Aplicacion.usecase.puntaje;

import backend.Dominio.modelo.PuntajeModel;
import backend.Dominio.puertos.in.puntaje.ListarPuntaje;
import backend.Dominio.puertos.out.puntaje.PuntajeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPuntajeUseCase implements ListarPuntaje {

    private final PuntajeRepositoryPort puntajeRepository;

    @Override
    public List<PuntajeModel> listarTodos(){
        return puntajeRepository.listarTodos();
    }

    @Override
    public List<PuntajeModel> buscarPorEstudiante(Long estudianteId){
        return puntajeRepository.buscarPorEstudiante(estudianteId);
    }
}
