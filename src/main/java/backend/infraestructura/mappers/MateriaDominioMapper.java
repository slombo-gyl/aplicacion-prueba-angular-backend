package backend.infraestructura.mappers;

import backend.dominio.modelo.Materia;
import backend.infraestructura.entities.MateriaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MateriaDominioMapper {

    MateriaEntity fromDominioModel(Materia materia);

    Materia toDominioModel(MateriaEntity entity);

    List<MateriaEntity> fromDominioModelList(List<Materia> materias);
}
