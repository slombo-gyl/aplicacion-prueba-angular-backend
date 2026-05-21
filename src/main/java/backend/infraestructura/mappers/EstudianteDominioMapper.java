package backend.infraestructura.mappers;

import backend.dominio.modelo.Estudiante;
import backend.infraestructura.entities.EstudianteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstudianteDominioMapper {

    EstudianteEntity toEntity(Estudiante estudiante);

    Estudiante toDominioModel(EstudianteEntity estudianteEntity);
}