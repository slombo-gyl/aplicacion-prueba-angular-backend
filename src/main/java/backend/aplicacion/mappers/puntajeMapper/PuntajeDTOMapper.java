package backend.aplicacion.mappers.puntajeMapper;

import backend.aplicacion.dto.puntaje.MateriaNotasDTOResponse;
import backend.aplicacion.services.estudiante.impl.EstudianteModelService;
import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.Materia;
import backend.dominio.modelo.Puntaje;

import backend.aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.aplicacion.services.materia.impl.MateriaModelService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class PuntajeDTOMapper {
    protected EstudianteModelService estudianteModelService;
    protected MateriaModelService materiaModelService;

    @Mapping(source = "estudianteId", target = "estudiante", qualifiedByName = "mapEstudianteIdAEstudiante")
    @Mapping(source = "materiaId", target = "materia", qualifiedByName = "mapMateriaIdAMateria")
    public abstract Puntaje toModel(RegistrarPuntajeDTORequest dto);

    @Named("mapEstudianteIdAEstudiante")
    protected Estudiante mapEstudianteIdAEstudiante(Long estudianteId) {
        return estudianteModelService.buscarEstudiantePorIdUseCase(estudianteId);
    }

    @Named("mapMateriaIdAMateria")
    protected Materia mapMateriaIdAMateria(Long materiaId) {
        return materiaModelService.buscarMateriaPorId(materiaId);
    }

    public List<MateriaNotasDTOResponse> toMateriaNotasDtoList(List<Puntaje> puntajes) {
        Map<Long, List<Puntaje>> porIdMateria = puntajes.stream()
                .collect(Collectors.groupingBy(puntaje -> puntaje.getMateria().getId()));

        return porIdMateria.entrySet().stream()
                .map(entry -> {
                    List<Puntaje> listaPuntajes = entry.getValue();
                    String nombreMateria = listaPuntajes.getFirst().getMateria().getNombre();
                    List<Double> notas = listaPuntajes.stream()
                            .map(Puntaje::getValor)
                            .toList();

                    return new MateriaNotasDTOResponse(
                            nombreMateria,
                            notas
                    );
                })
                .toList();
    }
}