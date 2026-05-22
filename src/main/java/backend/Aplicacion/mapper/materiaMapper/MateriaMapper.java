package backend.Aplicacion.mapper.materiaMapper;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Dominio.modelo.MateriaModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MateriaMapper {

    public abstract MateriaModel toModel(MateriaDTORequest dto);

    public abstract MateriaResponseDTO toResponseDto(MateriaModel model);

    public abstract List<MateriaResponseDTO> toResponseDtoList(List<MateriaModel> models);

}
