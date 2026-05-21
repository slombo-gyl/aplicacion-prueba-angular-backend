package backend.Aplicacion.services.materia.impl;

import backend.Aplicacion.usecase.materia.ActualizarMateriaUseCase;
import backend.Aplicacion.usecase.materia.BorrarMateriaUseCase;
import backend.Aplicacion.usecase.materia.ListarMateriaUseCase;
import backend.Aplicacion.usecase.materia.RegistrarMateriaUseCase;
import backend.Dominio.modelo.MateriaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MateriaModelService {

    private final RegistrarMateriaUseCase registrarMateriaUseCase;
    private final BorrarMateriaUseCase borrarMateriaUseCase;
    private final ListarMateriaUseCase listarMateriaUseCase;
    private final ActualizarMateriaUseCase actualizarMateriaUseCase;

    public List<MateriaModel> listarTodas() {
        return listarMateriaUseCase.listarTodas();
    }

    public Optional<MateriaModel> buscarPorId(Long id) {
        return listarMateriaUseCase.buscarPorId(id);
    }

    public Optional<MateriaModel> buscarPorNombre(String nombre) {
        return listarMateriaUseCase.buscarPorNombre(nombre);
    }

    public MateriaModel actualizar(MateriaModel materia) {
        return actualizarMateriaUseCase.actualizar(materia);
    }

    public MateriaModel borrado(Long id) {
        return borrarMateriaUseCase.borrado(id);
    }

    public MateriaModel guardar(MateriaModel materia) {
        return registrarMateriaUseCase.guardar(materia);
    }
}
