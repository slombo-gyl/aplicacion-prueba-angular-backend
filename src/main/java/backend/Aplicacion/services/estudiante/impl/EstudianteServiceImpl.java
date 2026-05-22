package backend.Aplicacion.services.estudiante.impl;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.mapper.estudianteMapper.EstudianteMapper;
import backend.Aplicacion.services.estudiante.EstudianteService;
import backend.Dominio.modelo.EstudianteModel;
import backend.Infraestructura.exceptions.GenericNoContentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteModelService estudianteModelService;
    private final EstudianteMapper estudianteMapper;


    @Override
    public EstudianteDTOResponse create(EstudianteDTORequest req) {
        EstudianteModel estudiante = estudianteMapper.toModel(req);
        EstudianteModel guardado = estudianteModelService.guardar(estudiante);
        return estudianteMapper.toResponseDto(guardado);
    }


    @Override
    public List<EstudianteDTOResponse> getAll() {
        return estudianteModelService.listarTodos()
                .stream()
                .map(estudianteMapper::toResponseDto)
                .toList();
    }


    @Override
    public EstudianteDTOResponse getById(Long id) {
        return estudianteModelService.buscarPorId(id)
                .map(estudianteMapper::toResponseDto)
                .orElseThrow(() -> new GenericNoContentException("Estudiante no encontrado"));
    }

    @Override
    public EstudianteDTOResponse update(Long id, EstudianteDTORequest req) {
        EstudianteModel estudiante = estudianteMapper.toModel(req);
        estudiante.setId(id);
        EstudianteModel actualizado = estudianteModelService.actualizar(estudiante);
        return estudianteMapper.toResponseDto(actualizado);
    }

    @Override
    public EstudianteDTOResponse delete(Long id) {
        return estudianteMapper.toResponseDto(estudianteModelService.borrar(id));
    }


    @Override
    public EstudianteDTOResponse activar(Long id) {
        return estudianteMapper.toResponseDto(estudianteModelService.activar(id));
    }

}