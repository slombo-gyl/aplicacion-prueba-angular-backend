package backend.Aplicacion.services.estudiante.impl;

import backend.Aplicacion.usecase.estudiante.*;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.in.estudiante.ActualizarEstudiante;
import backend.Dominio.puertos.in.estudiante.BorrarEstudiante;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstudianteModelService {

    private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final ListarEstudianteUseCase listarEstudianteUseCase;
    private final ActualizarEstudianteUseCase actualizarEstudianteUseCase;
    private final BorrarEstudianteUseCase borrarEstudianteUseCase;
    private final ActivarEstudianteUseCase activarEstudianteUseCase;



    public EstudianteModel guardar(EstudianteModel estudiante) {
        return registrarEstudianteUseCase.guardar(estudiante);
    }

    public List<EstudianteModel> listarTodos() {
        return listarEstudianteUseCase.listarTodos();
    }

    public Optional<EstudianteModel> buscarPorId(Long id) {
        return listarEstudianteUseCase.buscarPorId(id);
    }


    public EstudianteModel actualizar(EstudianteModel estudiante) {
        return actualizarEstudianteUseCase.actualizar(estudiante);
    }





    public EstudianteModel borrar(Long id) {
        return borrarEstudianteUseCase.borrar(id);
    }



    public EstudianteModel activar(Long id) {
        return activarEstudianteUseCase.activar(id);
    }

}