package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.MateriaResponseDTO;

public interface BuscarMateriaPorIdUseCase {

    MateriaResponseDTO ejecutar(Long id);
}
