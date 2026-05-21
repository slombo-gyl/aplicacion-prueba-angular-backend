package backend.Aplicacion.mapper.estudianteMapper;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Dominio.modelo.EstudianteModel;

public class EstudianteMapper {

    public static EstudianteDTOResponse toResponseDto(EstudianteModel model) {
        EstudianteDTOResponse dto = new EstudianteDTOResponse(
                model.getId(),
                model.getNombre(),
                model.getApellido(),
                model.getEmail(),
                model.getDni()
        );
        return dto;
    }


    public static EstudianteModel toModel(EstudianteDTORequest dto) {
        EstudianteModel model = new EstudianteModel();
        model.setNombre(dto.nombre());
        model.setApellido(dto.apellido());
        model.setEmail(dto.email());
        model.setDni(dto.dni());
        return model;
    }
}
