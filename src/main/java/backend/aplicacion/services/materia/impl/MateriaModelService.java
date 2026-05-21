package backend.aplicacion.services.materia.impl;

import backend.aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.dominio.modelo.Materia;
import backend.dominio.puertos.in.materia.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaModelService implements BuscarMateriaPorIdUseCase, EliminarMateriaUseCase, ListarTodasLasMateriasUseCase, ModificarMateriaUseCase, RegistrarMateriaUseCase, RestaurarMateriaUseCase {

    private final BuscarMateriaPorIdUseCase buscarMateriaPorIdUseCase;
    private final EliminarMateriaUseCase eliminarMateriaUseCase;
    private final ListarTodasLasMateriasUseCase listarTodasLasMateriasUseCase;
    private final ModificarMateriaUseCase modificarMateriaUseCase;
    private final RegistrarMateriaUseCase registrarMateriaUseCase;
    private final RestaurarMateriaUseCase restaurarMateriaUseCase;

    public MateriaModelService(BuscarMateriaPorIdUseCase buscarMateriaPorIdUseCase,
                               EliminarMateriaUseCase eliminarMateriaUseCase,
                               ListarTodasLasMateriasUseCase listarTodasLasMateriasUseCase,
                               ModificarMateriaUseCase modificarMateriaUseCase,
                               RegistrarMateriaUseCase registrarMateriaUseCase,
                               RestaurarMateriaUseCase restaurarMateriaUseCase) {
        this.buscarMateriaPorIdUseCase = buscarMateriaPorIdUseCase;
        this.eliminarMateriaUseCase = eliminarMateriaUseCase;
        this.listarTodasLasMateriasUseCase = listarTodasLasMateriasUseCase;
        this.modificarMateriaUseCase = modificarMateriaUseCase;
        this.registrarMateriaUseCase = registrarMateriaUseCase;
        this.restaurarMateriaUseCase = restaurarMateriaUseCase;
    }

    @Override
    public Materia buscarMateriaPorId(Long id) {
        return buscarMateriaPorIdUseCase.buscarMateriaPorId(id);
    }

    @Override
    public Materia eliminarMateria(Long id) {
        return eliminarMateriaUseCase.eliminarMateria(id);
    }

    @Override
    public List<Materia> listarTodasLasMaterias() {
        return listarTodasLasMateriasUseCase.listarTodasLasMaterias();
    }

    @Override
    public Materia actualizarMateria(Long id, ModificarMateriaDTORequest req) {
        return modificarMateriaUseCase.actualizarMateria(id, req);
    }

    @Override
    public Materia registrarMateria(RegistrarMateriaDTORequest dto) {
        return registrarMateriaUseCase.registrarMateria(dto);
    }

    @Override
    public Materia restaurarMateria(Long id) {
        return restaurarMateriaUseCase.restaurarMateria(id);
    }
}
