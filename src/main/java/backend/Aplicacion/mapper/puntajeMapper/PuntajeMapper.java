package backend.Aplicacion.mapper.puntajeMapper;

import backend.Aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.Aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.modelo.PuntajeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PuntajeMapper {

    @Mapping(target = "estudiante", source = "estudianteId", qualifiedByName = "idToEstudiante")
    @Mapping(target = "materia",    source = "materiaId",    qualifiedByName = "idToMateria")
    public abstract PuntajeModel toModel(PuntajeDTORequest dto);

    @Mapping(target = "estudianteId", source = "estudiante.id")
    @Mapping(target = "materiaId",    source = "materia.id")
    public abstract PuntajeDTOResponse toResponseDto(PuntajeModel model);

    public abstract List<PuntajeDTOResponse> toResponseDtoList(List<PuntajeModel> models);

    @Named("idToEstudiante")
    protected EstudianteModel idToEstudiante(Long id) {
        if (id == null) return null;
        EstudianteModel e = new EstudianteModel();
        e.setId(id);
        return e;
    }

    @Named("idToMateria")
    protected MateriaModel idToMateria(Long id) {
        if (id == null) return null;
        MateriaModel m = new MateriaModel();
        m.setId(id);
        return m;
    }
}