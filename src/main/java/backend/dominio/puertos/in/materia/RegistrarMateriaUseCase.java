package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.dominio.modelo.Materia;

public interface RegistrarMateriaUseCase {
    Materia registrarMateria (RegistrarMateriaDTORequest dto);
}
