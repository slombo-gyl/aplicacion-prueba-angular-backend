package backend.Aplicacion.mapper.estudianteMapper;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Dominio.modelo.EstudianteModel;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public static EstudianteEntity toEntity(EstudianteModel model) {
        EstudianteEntity entity = new EstudianteEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setEmail(model.getEmail());
        entity.setDni(model.getDni());
        return entity;
    }


    public static EstudianteModel toModel(EstudianteEntity entity) {
        EstudianteModel model = new EstudianteModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setEmail(entity.getEmail());
        model.setDni(entity.getDni());
        return model;
    }

    public static EstudianteModel dtoToModel(RegistrarEstudianteDTORequest dto) {
        EstudianteModel model = new EstudianteModel();
        model.setNombre(dto.nombre());
        model.setApellido(dto.apellido());
        model.setEmail(dto.email());
        model.setDni(dto.dni());
        return model;
    }

    public static void updateModelFromDto(ActualizarEstudianteDTORequest dto, EstudianteModel estudiante) {
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

    public static EstudianteDTOResponse toDTOResponse(EstudianteModel estudiante) {
        return new EstudianteDTOResponse(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEmail(),
                String.valueOf(estudiante.getDni())
        );
    }
}
