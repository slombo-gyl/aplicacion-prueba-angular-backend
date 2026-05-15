package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;

public interface BuscarMateriaPorId {

    MateriaResponseDTO ejecutar(Long id);
}
