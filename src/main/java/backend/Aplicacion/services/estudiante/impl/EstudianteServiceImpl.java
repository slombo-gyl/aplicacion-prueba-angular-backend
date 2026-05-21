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

    @Override
    public EstudianteDTOResponse create(EstudianteDTORequest req) {
        EstudianteModel estudiante = EstudianteMapper.toModel(req);
        EstudianteModel guardado = estudianteModelService.guardar(estudiante);
        return EstudianteMapper.toResponseDto(guardado);
    }


    @Override
    public List<EstudianteDTOResponse> getAll() {
        return estudianteModelService.listarTodos()
                .stream()
                .map(EstudianteMapper::toResponseDto)
                .toList();
    }


    @Override
    public EstudianteDTOResponse getById(Long id) {
        return estudianteModelService.buscarPorId(id)
                .map(EstudianteMapper::toResponseDto)
                .orElseThrow(() -> new GenericNoContentException("Estudiante no encontrado"));
    }

    @Override
    public EstudianteDTOResponse update(Long id, EstudianteDTORequest req) {
        EstudianteModel estudiante = EstudianteMapper.toModel(req);
        estudiante.setId(id);
        EstudianteModel actualizado = estudianteModelService.actualizar(estudiante);
        return EstudianteMapper.toResponseDto(actualizado);
    }

    @Override
    public EstudianteDTOResponse delete(Long id) {
        return EstudianteMapper.toResponseDto(estudianteModelService.borrar(id));
    }


    @Override
    public EstudianteDTOResponse activar(Long id) {
        return EstudianteMapper.toResponseDto(estudianteModelService.activar(id));
    }

}