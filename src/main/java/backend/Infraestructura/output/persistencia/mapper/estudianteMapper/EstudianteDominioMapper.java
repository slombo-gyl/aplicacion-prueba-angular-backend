package backend.Infraestructura.output.persistencia.mapper.estudianteMapper;

import backend.Dominio.modelo.EstudianteModel;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;

public class EstudianteDominioMapper {

    private EstudianteDominioMapper(){}

    public static EstudianteEntity toEntity(EstudianteModel model) {
        EstudianteEntity entity = new EstudianteEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setEmail(model.getEmail());
        entity.setDni(model.getDni());
        entity.setInsertFecha(model.getInsertFecha());
        entity.setDeleteFecha(model.getDeleteFecha());
        return entity;
    }

    public static EstudianteModel toModel(EstudianteEntity entity) {
        EstudianteModel model = new EstudianteModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setEmail(entity.getEmail());
        model.setDni(entity.getDni());
        model.setInsertFecha(entity.getInsertFecha());
        model.setDeleteFecha(entity.getDeleteFecha());
        return model;
    }
}
