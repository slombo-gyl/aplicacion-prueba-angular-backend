package backend.Infraestructura.output.persistencia.mapper.materiaMapper;

import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;

public class MateriaDominioMapper {

    private MateriaDominioMapper(){}

    public static MateriaEntity toEntity (MateriaModel model){
        MateriaEntity entity = new MateriaEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setActivo(model.isActivo());
        entity.setDeleteFecha(model.getDeleteFecha());
        entity.setInsertFecha(model.getInsertFecha());
        return entity;
    }

    public static MateriaModel toModel(MateriaEntity entity) {
        MateriaModel model = new MateriaModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setActivo(entity.isActivo());
        model.setDeleteFecha(entity.getDeleteFecha());
        model.setInsertFecha(entity.getInsertFecha());
        return model;
    }
}
