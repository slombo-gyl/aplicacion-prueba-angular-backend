package backend.Aplicacion.mapper.materiaMapper;

import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;

public class MateriaMapper {
    public static MateriaEntity toEntity(MateriaModel model) {
        MateriaEntity entity = new MateriaEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setFechaBaja(model.getFechaBaja());
        return entity;
    }

    public static  MateriaModel toModel(MateriaEntity entity){
        MateriaModel model = new MateriaModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setFechaBaja(entity.getFechaBaja());
        return  model;
    }
}