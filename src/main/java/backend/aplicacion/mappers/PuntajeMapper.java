package backend.aplicacion.mappers;

import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.dominio.modelos.EstudianteModel;
import backend.dominio.modelos.MateriaModel;
import backend.dominio.modelos.PuntajeModel;
import backend.infraestructura.entidades.EstudianteEntity;
import backend.infraestructura.entidades.MateriaEntity;
import backend.infraestructura.entidades.PuntajeEntity;

public class PuntajeMapper {
    public static PuntajeEntity toEntity(PuntajeModel model, MateriaEntity materia, EstudianteEntity estudiante) {
        PuntajeEntity entity = new PuntajeEntity();

        entity.setId(model.getId());
        entity.setValor(model.getValor());
        entity.setEstudiante(estudiante);
        entity.setMateria(materia);

        return entity;
    }

    public static PuntajeModel toModel(PuntajeEntity entity) {
        PuntajeModel model = new PuntajeModel();

        model.setId(entity.getId());
        model.setValor(entity.getValor());

        if (entity.getEstudiante() != null) {
            EstudianteModel estudianteModel = new EstudianteModel();
            estudianteModel.setId(entity.getEstudiante().getId());
            estudianteModel.setNombre(entity.getEstudiante().getNombre());
            estudianteModel.setApellido(entity.getEstudiante().getApellido());
            estudianteModel.setEmail(entity.getEstudiante().getEmail());
            estudianteModel.setDni(entity.getEstudiante().getDni());
            model.setEstudiante(estudianteModel);
        }

        if (entity.getMateria() != null) {
            MateriaModel materiaModel = new MateriaModel();
            materiaModel.setId(entity.getMateria().getId());
            materiaModel.setNombre(entity.getMateria().getNombre());
            model.setMateria(materiaModel);
        }

        return model;
    }

    public static PuntajeDTOResponse toResponseDto(PuntajeModel model) {
        return new PuntajeDTOResponse(
                model.getEstudiante().getId(),
                model.getMateria().getId(),
                model.getValor()
        );
    }
}