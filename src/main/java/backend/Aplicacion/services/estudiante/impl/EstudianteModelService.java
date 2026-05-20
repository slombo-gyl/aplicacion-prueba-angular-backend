package backend.Aplicacion.services.estudiante.impl;

import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Dominio.puertos.in.Student.RegistrarEstudiante;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstudianteModelService implements RegistrarEstudiante {

    private final RegistrarEstudiante registrarEstudiante;

    @Override
    public Long ejecutar(RegistrarEstudianteDTORequest req) {
        return registrarEstudiante.ejecutar(req);
    }
}