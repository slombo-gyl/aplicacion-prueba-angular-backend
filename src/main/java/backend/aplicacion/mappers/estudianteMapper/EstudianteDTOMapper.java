package backend.aplicacion.mappers.estudianteMapper;

import backend.aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.dominio.modelo.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EstudianteDTOMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Estudiante toModel(RegistrarEstudianteDTORequest dto);

    EstudianteDTOResponse toDto(Estudiante estudiante);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Estudiante updateModelFromDto(ActualizarEstudianteDTORequest dto);

    EstadoEstudianteDTOResponse toEstadoDto(Estudiante estudiante);
}