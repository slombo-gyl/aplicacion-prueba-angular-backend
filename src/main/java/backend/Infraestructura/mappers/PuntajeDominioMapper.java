package backend.Infraestructura.mappers;

import backend.dominio.modelo.Puntaje;
import backend.Infraestructura.entitites.PuntajeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstudianteDominioMapper.class, MateriaDominioMapper.class})
public interface PuntajeDominioMapper {

    PuntajeEntity fromDominioModel(Puntaje puntaje);

    Puntaje toDominioModel(PuntajeEntity entity);

    List<PuntajeEntity> fromDominioModelList(List<Puntaje> puntajes);
}