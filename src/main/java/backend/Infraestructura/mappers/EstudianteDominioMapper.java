package backend.Infraestructura.mappers;
import backend.dominio.modelo.Estudiante;
import backend.Infraestructura.entitites.EstudianteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteDominioMapper {

    EstudianteEntity fromDominioModel(Estudiante estudiante);

    Estudiante toDominioModel(EstudianteEntity estudianteEntity);

    List<EstudianteEntity> fromDominioModelList(List<Estudiante> estudiantes);
}
