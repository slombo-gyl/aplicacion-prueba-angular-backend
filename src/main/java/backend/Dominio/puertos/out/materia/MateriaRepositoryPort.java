package backend.Dominio.puertos.out.materia;

import backend.Dominio.modelo.Materia;

import java.util.List;
import java.util.Optional;

public interface MateriaRepositoryPort {
    Materia guardar(Materia materia);
    Optional<Materia>buscarPorId(Long id);
    Optional<Materia> buscarActivaPorId(Long id);
    List<Materia> obtenerTodasLasMateriasActivas();
}
