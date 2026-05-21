package backend.Aplicacion.services.estudiante.impl;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Dominio.puertos.in.estudiante.RegistrarEstudiante;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstudianteModelService implements RegistrarEstudiante {

    private final RegistrarEstudiante registrarEstudiante;

    @Override
    public Long ejecutar(EstudianteDTORequest req) {
        return registrarEstudiante.ejecutar(req);
    }
}