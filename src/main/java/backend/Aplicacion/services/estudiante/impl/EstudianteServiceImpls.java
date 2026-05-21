package backend.aplicacion.services.estudiante.impl;

import backend.aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.aplicacion.mappers.estudianteMapper.EstudianteDTOMapper;
import backend.aplicacion.services.estudiante.EstudianteService;
import backend.dominio.modelo.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpls implements EstudianteService {
    private final EstudianteModelServices estudianteModelService;
    private final EstudianteDTOMapper estudianteDTOMapper;

    public EstudianteServiceImpls(EstudianteModelServices estudianteModelService, EstudianteDTOMapper estudianteDTOMapper) {
        this.estudianteModelService = estudianteModelService;
        this.estudianteDTOMapper = estudianteDTOMapper;
    }


    @Override
    public EstudianteDTOResponse registrar(RegistrarEstudianteDTORequest estudianteDto) {
        Estudiante estudiante = estudianteDTOMapper.toModel(estudianteDto);
         Estudiante newEstudiante = estudianteModelService.registrarEstudianteUseCase(estudiante);
         return estudianteDTOMapper.toDto(newEstudiante);
     }

    @Override
    public List<EstudianteDTOResponse> listarTodosLosEstudiantes() {
        return estudianteDTOMapper.toDtoList(estudianteModelService.listarTodosLosEstudiantesUseCase());
    }

    @Override
    public EstudianteDTOResponse buscarPorId(Long id) {
        Estudiante estudiante = estudianteModelService.buscarEstudiantePorIdUseCase(id);
        return estudianteDTOMapper.toDto(estudiante);
    }

    @Override
    public EstudianteDTOResponse actualizar(Long id, ActualizarEstudianteDTORequest estudianteDtoToUpdate) {
        Estudiante estudiante = estudianteModelService.actualizarEstudianteUseCase(id, estudianteDTOMapper.updateModelFromDto(estudianteDtoToUpdate));
        return estudianteDTOMapper.toDto(estudiante);
    }

    @Override
    public EstadoEstudianteDTOResponse baja(Long id) {
        Estudiante estudiante = estudianteModelService.bajaEstudianteUseCase(id);
        return estudianteDTOMapper.toEstadoDto(estudiante);
    }

    @Override
    public EstadoEstudianteDTOResponse reactivar(Long id) {
        Estudiante estudiante = estudianteModelService.reactivarEstudianteUseCase(id);
        return estudianteDTOMapper.toEstadoDto(estudiante);
    }
}