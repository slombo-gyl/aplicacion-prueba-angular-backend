package backend.Aplicacion.services.estudiante.impl;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.services.estudiante.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteModelService estudianteModelService;

    @Override
    public EstudianteDTOResponse registrar(EstudianteDTORequest req) {
        return estudianteModelService.ejecutar(req);
    }
}