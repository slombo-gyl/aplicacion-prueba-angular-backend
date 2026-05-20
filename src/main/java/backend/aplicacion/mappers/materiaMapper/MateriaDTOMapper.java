package backend.aplicacion.mappers.materiaMapper;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.dominio.modelo.Materia;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MateriaDTOMapper {

    Materia toModel(RegistrarMateriaDTORequest dto);

    MateriaResponseDTO toDto(Materia materia);

    List<MateriaResponseDTO> toDtoList(List<Materia> materias);
}
