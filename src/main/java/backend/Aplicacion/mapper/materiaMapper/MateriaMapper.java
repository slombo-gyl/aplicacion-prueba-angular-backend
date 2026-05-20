package backend.Aplicacion.mapper.materiaMapper;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Dominio.modelo.Materia;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;

public class MateriaMapper {

    public static MateriaEntity toEntity(Materia model) {
        MateriaEntity entity = new MateriaEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setPuntaje(model.getPuntaje());
        entity.setEstado(model.getEstado());
        return entity;
    }

    public static Materia toModel(MateriaEntity entity){
        Materia model = new Materia();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setPuntaje(entity.getPuntaje());
        model.setEstado(entity.getEstado());
        return  model;
    }

    public static MateriaResponseDTO toDTOResponse(Materia materia) {
        return new MateriaResponseDTO(
                materia.getId(),
                materia.getNombre()
        );
    }
}
