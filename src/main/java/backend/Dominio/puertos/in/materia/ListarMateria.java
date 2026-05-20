package backend.Dominio.puertos.in.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Dominio.modelo.MateriaModel;

import java.util.List;

public interface ListarMateria {
    List<MateriaResponseDTO> ejecutar();
}
