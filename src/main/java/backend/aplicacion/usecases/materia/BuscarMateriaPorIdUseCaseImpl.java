package backend.aplicacion.usecases.materia;

import backend.dominio.modelo.Materia;
import backend.dominio.puertos.in.materia.BuscarMateriaPorIdUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscarMateriaPorIdUseCaseImpl implements BuscarMateriaPorIdUseCase {

    private final MateriaModelPort repository;

    @Override
    public Materia buscarMateriaPorId(Long id) {
        return repository.buscarActivaPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Materia no encontrada o inactiva con id: " + id));
    }
}
