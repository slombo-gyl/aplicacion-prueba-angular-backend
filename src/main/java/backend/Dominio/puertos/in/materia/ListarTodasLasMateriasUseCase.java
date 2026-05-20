package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;

import java.util.List;

public interface ListarTodasLasMateriasUseCase {

    List<MateriaResponseDTO> ejecutar();
}
