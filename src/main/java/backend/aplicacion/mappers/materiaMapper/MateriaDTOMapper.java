package backend.aplicacion.mappers.materiaMapper;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.dominio.modelo.Materia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MateriaDTOMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "puntaje", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Materia toModel(RegistrarMateriaDTORequest dto);

    MateriaResponseDTO toDto(Materia materia);

    List<MateriaResponseDTO> toDtoList(List<Materia> materias);
}