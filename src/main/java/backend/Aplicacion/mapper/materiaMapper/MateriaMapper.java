package backend.Aplicacion.mapper.materiaMapper;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;

public class MateriaMapper {

    public static MateriaEntity toEntity(MateriaModel model) {
        MateriaEntity entity = new MateriaEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        return entity;
    }

    public static  MateriaModel toModel(MateriaEntity entity){
        MateriaModel model = new MateriaModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        return  model;
    }

    public static MateriaResponseDTO toResponse(MateriaModel model){
        return new MateriaResponseDTO(
                model.getId(),
                model.getNombre()
        );
    }
}
