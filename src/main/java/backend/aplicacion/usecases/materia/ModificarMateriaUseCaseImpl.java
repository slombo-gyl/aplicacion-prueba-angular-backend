package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.aplicacion.dto.materia.ModificarMateriaDTOResponse;
import backend.dominio.modelo.Materia;
import backend.dominio.puertos.in.materia.ModificarMateriaUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ModificarMateriaUseCaseImpl implements ModificarMateriaUseCase {

    private final MateriaModelPort materiaModelPort;

    @Override
    public ModificarMateriaDTOResponse ejecutar(Long id, ModificarMateriaDTORequest req) {
        Materia materia = materiaModelPort.buscarPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Materia no encontrada"));

        materia.setNombre(req.nombre());

        Materia materiaGuardada = materiaModelPort.guardar(materia);

        return new ModificarMateriaDTOResponse(
                materiaGuardada.getId(),
                materiaGuardada.getNombre()
        );
    }
}
