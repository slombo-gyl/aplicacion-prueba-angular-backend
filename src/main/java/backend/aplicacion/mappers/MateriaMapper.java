package backend.aplicacion.mappers;

import backend.aplicacion.dto.materia.MateriaDTOResponse;
import backend.dominio.modelos.MateriaModel;
import backend.infraestructura.entidades.MateriaEntity;

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

    public static MateriaDTOResponse toResponseDto(MateriaModel model){
        return new MateriaDTOResponse(
                model.getId(),
                model.getNombre(),
                model.getFechaBaja()
        );
    }
}