package backend.aplicacion.mappers;

import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.dominio.modelos.EstudianteModel;
import backend.infraestructura.entidades.EstudianteEntity;

public class EstudianteMapper {
    public static EstudianteEntity toEntity(EstudianteModel model) {
        EstudianteEntity entity = new EstudianteEntity();

        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setEmail(model.getEmail());
        entity.setDni(model.getDni());
        entity.setFechaBaja(model.getFechaBaja());

        return entity;
    }

    public static EstudianteModel toModel(EstudianteEntity entity) {
        EstudianteModel model = new EstudianteModel();

        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setEmail(entity.getEmail());
        model.setDni(entity.getDni());
        model.setFechaBaja(entity.getFechaBaja());

        return model;
    }
    
    public static EstudianteDTOResponse toResponseDto(EstudianteModel model){
        return new EstudianteDTOResponse(
                model.getId(),
                model.getNombre(),
                model.getApellido(),
                model.getEmail(),
                model.getDni(),
                model.getFechaBaja()
        );
    }
}