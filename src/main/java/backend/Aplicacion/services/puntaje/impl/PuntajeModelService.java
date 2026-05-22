package backend.Aplicacion.services.puntaje.impl;

import backend.Aplicacion.usecase.puntaje.ActualizarPuntajeUseCase;
import backend.Aplicacion.usecase.puntaje.ListarPuntajeUseCase;
import backend.Aplicacion.usecase.puntaje.RegistrarPuntajeUseCase;
import backend.Dominio.modelo.PuntajeModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PuntajeModelService {

    private final RegistrarPuntajeUseCase registrarPuntajeUseCase;
    private final ListarPuntajeUseCase listarPuntajeUseCase;
    private final ActualizarPuntajeUseCase actualizarPuntajeUseCase;

    public PuntajeModel guardar(PuntajeModel puntaje, Long materiaId, Long estudianteId) {
        return registrarPuntajeUseCase.guardar(puntaje, materiaId, estudianteId);
    }
    public List<PuntajeModel> buscarPorEstudiante(Long estudianteId) {
        return listarPuntajeUseCase.buscarPorEstudiante(estudianteId);
    }
    public List<PuntajeModel> listarTodos() {
        return listarPuntajeUseCase.listarTodos();
    }

    public PuntajeModel actualizar(PuntajeModel puntaje) {
        return actualizarPuntajeUseCase.actualizar(puntaje);
    }
}
