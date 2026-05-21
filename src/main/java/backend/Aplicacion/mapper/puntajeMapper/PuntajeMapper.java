package backend.Aplicacion.mapper.puntajeMapper;

import backend.Aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.Aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.modelo.PuntajeModel;

public class PuntajeMapper {

    public static PuntajeModel toModel(PuntajeDTORequest dto) {
        PuntajeModel model = new PuntajeModel();
        model.setValor(dto.valor());

        EstudianteModel estudiante = new EstudianteModel();
        estudiante.setId(dto.estudianteId());
        model.setEstudiante(estudiante);

        MateriaModel materia = new MateriaModel();
        materia.setId(dto.materiaId());
        model.setMateria(materia);

        return model;
    }

    public static PuntajeDTOResponse toResponseDto(PuntajeModel model) {
        Long estudianteId = model.getEstudiante() != null ? model.getEstudiante().getId() : null;
        Long materiaId = model.getMateria() != null ? model.getMateria().getId() : null;

        return new PuntajeDTOResponse(
                model.getId(),
                estudianteId,
                materiaId,
                model.getValor(),
                model.getInsertFecha()
        );
    }
}
