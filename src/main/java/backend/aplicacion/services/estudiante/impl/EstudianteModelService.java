package backend.aplicacion.services.estudiante.impl;

import backend.dominio.modelo.Estudiante;
import backend.dominio.puertos.in.student.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteModelService implements RegistrarEstudianteUseCase, ActualizarEstudianteUseCase, BajaEstudianteUseCase, BuscarEstudiantePorIdUseCase, ListarTodosLosEstudiantesUseCase, ReactivarEstudianteUseCase {
    private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final ActualizarEstudianteUseCase actualizarEstudianteUseCase;
    private final BajaEstudianteUseCase bajaEstudianteUseCase;
    private final BuscarEstudiantePorIdUseCase buscarEstudiantePorIdUseCase;
    private final ListarTodosLosEstudiantesUseCase listarTodosLosEstudiantesUseCase;
    private final ReactivarEstudianteUseCase reactivarEstudianteUseCase;

    public EstudianteModelService(RegistrarEstudianteUseCase registrarEstudianteUseCase, ActualizarEstudianteUseCase actualizarEstudianteUseCase, BajaEstudianteUseCase bajaEstudianteUseCase, BuscarEstudiantePorIdUseCase buscarEstudiantePorIdUseCase, ListarTodosLosEstudiantesUseCase listarTodosLosEstudiantesUseCase, ReactivarEstudianteUseCase reactivarEstudianteUseCase) {
        this.registrarEstudianteUseCase = registrarEstudianteUseCase;
        this.actualizarEstudianteUseCase = actualizarEstudianteUseCase;
        this.bajaEstudianteUseCase = bajaEstudianteUseCase;
        this.buscarEstudiantePorIdUseCase = buscarEstudiantePorIdUseCase;
        this.listarTodosLosEstudiantesUseCase = listarTodosLosEstudiantesUseCase;
        this.reactivarEstudianteUseCase = reactivarEstudianteUseCase;
    }

    @Override
    public Estudiante actualizarEstudianteUseCase(Long id, Estudiante estudiante) {
        return actualizarEstudianteUseCase.actualizarEstudianteUseCase(id, estudiante);
    }

    @Override
    public Estudiante bajaEstudianteUseCase(Long id) {
        return bajaEstudianteUseCase.bajaEstudianteUseCase(id);
    }

    @Override
    public Estudiante buscarEstudiantePorIdUseCase(Long id) {
        return buscarEstudiantePorIdUseCase.buscarEstudiantePorIdUseCase(id);
    }

    @Override
    public List<Estudiante> listarTodosLosEstudiantesUseCase() {
        return listarTodosLosEstudiantesUseCase.listarTodosLosEstudiantesUseCase();
    }

    @Override
    public Estudiante reactivarEstudianteUseCase(Long id) {
        return reactivarEstudianteUseCase.reactivarEstudianteUseCase(id);
    }

    @Override
    public Estudiante registrarEstudianteUseCase(Estudiante estudiante) {
        return registrarEstudianteUseCase.registrarEstudianteUseCase(estudiante);
    }
}