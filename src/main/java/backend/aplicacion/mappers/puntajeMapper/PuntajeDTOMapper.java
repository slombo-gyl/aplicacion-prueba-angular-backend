package backend.aplicacion.mappers.puntajeMapper;

import backend.aplicacion.services.estudiante.impl.EstudianteModelService;
import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.Materia;
import backend.dominio.modelo.Puntaje;

import backend.aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.aplicacion.services.materia.impl.MateriaModelService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class PuntajeDTOMapper {

    protected EstudianteModelService estudianteModelService;
    protected MateriaModelService materiaModelService;

    @Mapping(source = "estudianteId", target = "estudiante", qualifiedByName = "mapEstudianteIdAEstudiante")
    @Mapping(source = "materiaId", target = "materia", qualifiedByName = "mapMateriaIdAMateria")
    public abstract Puntaje toModel(RegistrarPuntajeDTORequest dto);

    @Named("mapEstudianteIdAEstudiante")
    protected Estudiante mapEstudianteIdAEstudiante(Long estudianteId) {
        return estudianteModelService.buscarPorId(estudianteId);
    }

    @Named("mapMateriaIdAMateria")
    protected Materia mapMateriaIdAMateria(Long materiaId) {
        return materiaModelService.buscarPorId(materiaId);
    }
}
