package backend.Infraestructura.mappers;

import backend.dominio.modelo.Materia;
import backend.Infraestructura.entitites.MateriaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MateriaDominioMapper {

    MateriaEntity fromDominioModel(Materia materia);

    Materia toDominioModel(MateriaEntity entity);

    List<MateriaEntity> fromDominioModelList(List<Materia> materias);
}
