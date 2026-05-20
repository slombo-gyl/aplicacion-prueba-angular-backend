package backend.Aplicacion.mappers.estudianteMapper;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.modelo.enums.Estado;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import org.springframework.stereotype.Component;

@Component
public class EstudianteDTOMapper {

    public static EstudianteEntity toEntity(Estudiante model) {
        EstudianteEntity entity = new EstudianteEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setEmail(model.getEmail());
        entity.setDni(model.getDni());
        entity.setEstado(model.getEstado());
        return entity;
    }


    public static Estudiante toModel(EstudianteEntity entity) {
        Estudiante model = new Estudiante();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setEmail(entity.getEmail());
        model.setDni(entity.getDni());
        model.setEstado(entity.getEstado());
        return model;
    }

    public static Estudiante dtoToModel(RegistrarEstudianteDTORequest dto) {
        Estudiante model = new Estudiante();
        model.setNombre(dto.nombre());
        model.setApellido(dto.apellido());
        model.setEmail(dto.email());
        model.setDni(dto.dni());
        model.setEstado(Estado.ACTIVO);
        return model;
    }

    public static void updateModelFromDto(ActualizarEstudianteDTORequest dto, Estudiante estudiante) {
        if (dto == null) return;

        if (dto.nombre() != null) {
            estudiante.setNombre(dto.nombre());
        }
        if (dto.apellido() != null) {
            estudiante.setApellido(dto.apellido());
        }
        if (dto.email() != null) {
            estudiante.setEmail(dto.email());
        }
        if (dto.dni() != null) {
            estudiante.setDni(dto.dni());
        }
    }

    public static EstudianteDTOResponse toDTOResponse(Estudiante estudiante) {
        return new EstudianteDTOResponse(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEmail(),
                String.valueOf(estudiante.getDni()),
                estudiante.getEstado()
        );
    }
}
