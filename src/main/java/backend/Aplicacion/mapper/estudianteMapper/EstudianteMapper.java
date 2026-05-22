package backend.Aplicacion.mapper.estudianteMapper;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EstudianteMapper {

    public abstract EstudianteDTOResponse toResponseDto(EstudianteModel model);


    public abstract EstudianteModel toModel(EstudianteDTORequest dto);

    public abstract List<EstudianteDTOResponse> toResponseDtoList(List<EstudianteModel> models);

}
