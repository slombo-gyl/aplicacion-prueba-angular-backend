package backend.aplicacion.usecases.materia;

import backend.dominio.modelo.Materia;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.materia.RestaurarMateriaUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurarMateriaUseCaseImpl implements RestaurarMateriaUseCase {

    private final MateriaModelPort repository;

    @Override
    public Materia restaurarMateria(Long id) {
        Materia materia = repository.buscarPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Materia no encontrada con id: " + id));

        materia.setEstado(Estado.ACTIVO);

        return repository.guardar(materia);
    }
}
