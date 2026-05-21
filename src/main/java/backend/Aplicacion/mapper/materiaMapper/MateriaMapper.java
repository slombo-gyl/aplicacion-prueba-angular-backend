package backend.Aplicacion.mapper.materiaMapper;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Dominio.modelo.MateriaModel;

public class MateriaMapper {

    public static MateriaModel toModel(MateriaDTORequest dto) {
        MateriaModel model = new MateriaModel();
        model.setNombre(dto.nombre());
        return model;
    }

    public static MateriaResponseDTO toResponseDto(MateriaModel model) {
        return new MateriaResponseDTO(
                model.getId(),
                model.getNombre(),
                model.getInsertFecha(),
                model.getDeleteFecha()
        );
    }
}
