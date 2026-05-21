package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.MateriaDTOResponse;
import backend.aplicacion.mappers.MateriaMapper;
import backend.dominio.puertos.out.MateriaModelPort;

public interface ObtenerMateriasUseCase {MateriaDTOResponse ejecutar (Long id);}