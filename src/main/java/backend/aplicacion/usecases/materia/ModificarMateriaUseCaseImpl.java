package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.dominio.modelo.Materia;
import backend.dominio.puertos.in.materia.ModificarMateriaUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModificarMateriaUseCaseImpl implements ModificarMateriaUseCase {

    private final MateriaModelPort repository;

    @Override
    public Materia actualizarMateria(Long id, ModificarMateriaDTORequest req) {
        Materia materia = repository.buscarActivaPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Materia no encontrada o inactiva con id: " + id));

        materia.setNombre(req.nombre());

        return repository.guardar(materia);
    }
}
