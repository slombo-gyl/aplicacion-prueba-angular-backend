package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;

public interface BuscarMateriaPorIdUseCase {

    MateriaResponseDTO ejecutar(Long id);
}
