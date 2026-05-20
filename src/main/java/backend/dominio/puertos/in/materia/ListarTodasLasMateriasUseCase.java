package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.MateriaResponseDTO;

import java.util.List;

public interface ListarTodasLasMateriasUseCase {

    List<MateriaResponseDTO> ejecutar();
}
