package backend.Aplicacion.mapper.estudianteMapper;

import backend.Dominio.modelo.EstudianteModel;
import backend.Infraestructura.output.persistencia.entity.estudiante.StudentEntity;

public class StudentMapper {

    public static StudentEntity toEntity(EstudianteModel model) {
        StudentEntity entity = new StudentEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setEmail(model.getEmail());
        entity.setDni(model.getDni());
        return entity;
    }


    public static EstudianteModel toModel(StudentEntity entity) {
        EstudianteModel model = new EstudianteModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setEmail(entity.getEmail());
        model.setDni(entity.getDni());
        return model;
    }
}
