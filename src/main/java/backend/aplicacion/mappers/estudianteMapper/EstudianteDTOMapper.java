package backend.aplicacion.mappers.estudianteMapper;

import backend.aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.dominio.modelo.Estudiante;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteDTOMapper {

    Estudiante toModel(RegistrarEstudianteDTORequest dto);

    EstudianteDTOResponse toDto(Estudiante estudiante);

    List<EstudianteDTOResponse> toDtoList(List<Estudiante> estudiantes);

    Estudiante updateModelFromDto(ActualizarEstudianteDTORequest dto);

    EstadoEstudianteDTOResponse toEstadoDto(Estudiante estudiante);
}