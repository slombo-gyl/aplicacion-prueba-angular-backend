package backend.Aplicacion.mapper.materiaMapper;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.MateriaModel;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;

public class MateriaMapper {

    public static MateriaEntity toEntity(MateriaModel model) {
        MateriaEntity entity = new MateriaEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setPuntaje(model.getPuntaje());
        entity.setEstado(model.getEstado());
        return entity;
    }

    public static  MateriaModel toModel(MateriaEntity entity){
        MateriaModel model = new MateriaModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setPuntaje(entity.getPuntaje());
        model.setEstado(entity.getEstado());
        return  model;
    }

    public static MateriaResponseDTO toDTOResponse(MateriaModel materia) {
        return new MateriaResponseDTO(
                materia.getId(),
                materia.getNombre()
        );
    }
}
