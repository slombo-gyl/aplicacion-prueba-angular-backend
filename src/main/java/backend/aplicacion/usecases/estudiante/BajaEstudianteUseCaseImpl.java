package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.student.BajaEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.Infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BajaEstudianteUseCaseImpl implements BajaEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public EstadoEstudianteDTOResponse bajaEstudianteUseCase(Long id) {
        Estudiante estudiante = repository.obtenerPorId(id)
                        .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));

        estudiante.setEstado(Estado.INACTIVO);
        repository.guardar(estudiante);

        return new EstadoEstudianteDTOResponse(estudiante.getId(), "El estudiante fue dado de baja");
    }
}