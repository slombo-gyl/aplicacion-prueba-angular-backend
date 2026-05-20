package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.student.ReactivarEstudianteUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReactivarEstudianteUseCaseImpl implements ReactivarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public EstadoEstudianteDTOResponse reactivarEstudianteUseCase(Long id) {
        Estudiante estudiante = repository.obtenerPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));

        estudiante.setEstado(Estado.ACTIVO);
        repository.guardar(estudiante);

        return new EstadoEstudianteDTOResponse(estudiante.getId(), "El estudiante fue dado de reactivado");
    }
}
