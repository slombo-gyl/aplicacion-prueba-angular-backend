package backend.Aplicacion.mapper.puntajeMapper;

import backend.Dominio.modelo.Estudiante;
import backend.Dominio.modelo.Materia;
import backend.Dominio.modelo.Puntaje;
import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.entity.puntaje.PuntajeEntity;

public class PuntajeMapper {

    public static PuntajeEntity toEntity(Puntaje model,
                                         MateriaEntity materia,
                                         EstudianteEntity estudiante) {
        PuntajeEntity entity = new PuntajeEntity();
        entity.setId(model.getId());
        entity.setValor(model.getValor());
        entity.setEstudiante(estudiante);
        entity.setMateria(materia);
        return entity;
    }

    public static Puntaje toModel(PuntajeEntity entity) {
        Puntaje model = new Puntaje();
        model.setId(entity.getId());
        model.setValor(entity.getValor());


        if (entity.getEstudiante() != null) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(entity.getEstudiante().getId());
            estudiante.setNombre(entity.getEstudiante().getNombre());
            estudiante.setApellido(entity.getEstudiante().getApellido());
            estudiante.setEmail(entity.getEstudiante().getEmail());
            estudiante.setDni(entity.getEstudiante().getDni());
            model.setEstudiante(estudiante);
        }

        if (entity.getMateria() != null) {
            Materia materia = new Materia();
            materia.setId(entity.getMateria().getId());
            materia.setNombre(entity.getMateria().getNombre());
            model.setMateria(materia);
        }

        return model;
    }
}
