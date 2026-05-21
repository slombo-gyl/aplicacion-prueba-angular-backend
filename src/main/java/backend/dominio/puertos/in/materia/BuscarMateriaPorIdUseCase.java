package backend.dominio.puertos.in.materia;

import backend.dominio.modelo.Materia;

public interface BuscarMateriaPorIdUseCase {

    Materia buscarMateriaPorId(Long id);
}
