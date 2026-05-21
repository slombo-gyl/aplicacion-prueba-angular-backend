package backend.Aplicacion.services.estudiante.impl;

import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Aplicacion.services.estudiante.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteModelService estudianteModelService;

    @Override
    public Long registrar(RegistrarEstudianteDTORequest req) {
        return estudianteModelService.ejecutar(req);
    }
}