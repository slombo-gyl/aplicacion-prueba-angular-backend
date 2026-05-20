package backend.dominio.puertos.out.materia;

import backend.dominio.modelo.Materia;

import java.util.List;
import java.util.Optional;

public interface MateriaModelPort {
    Materia guardar(Materia materia);
    Optional<Materia>buscarPorId(Long id);
    Optional<Materia> buscarActivaPorId(Long id);
    List<Materia> obtenerTodasLasMateriasActivas();
}
