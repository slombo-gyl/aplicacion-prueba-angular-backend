package backend.Aplicacion.usecase.materia.modificar;

import backend.Aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.Aplicacion.dto.materia.ModificarMateriaDTOResponse;
import backend.Dominio.modelo.Materia;
import backend.Dominio.puertos.in.materia.ModificarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.shared.exception.NoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ModificarMateriaUseCase implements ModificarMateria {

    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public ModificarMateriaDTOResponse ejecutar(Long id, ModificarMateriaDTORequest req) {
        Materia materia = materiaRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Materia no encontrada"));

        materia.setNombre(req.nombre());

        Materia materiaGuardada = materiaRepositoryPort.guardar(materia);

        return new ModificarMateriaDTOResponse(
                materiaGuardada.getId(),
                materiaGuardada.getNombre()
        );
    }
}
