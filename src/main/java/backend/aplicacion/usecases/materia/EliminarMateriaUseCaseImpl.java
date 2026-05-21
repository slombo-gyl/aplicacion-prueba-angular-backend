package backend.aplicacion.usecases.materia;

import backend.dominio.modelo.Materia;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.materia.EliminarMateriaUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarMateriaUseCaseImpl implements EliminarMateriaUseCase {

    private final MateriaModelPort repository;

    @Override
    public Materia eliminarMateria(Long id) {
        Materia materia = repository.buscarActivaPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Materia no encontrada o ya inactiva con id: " + id));

        materia.setEstado(Estado.INACTIVO);

        return repository.guardar(materia);
    }
}
