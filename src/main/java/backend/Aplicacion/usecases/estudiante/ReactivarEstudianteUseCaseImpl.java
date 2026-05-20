package backend.Aplicacion.usecases.estudiante;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.in.student.ReactivarEstudianteUseCase;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.Infraestructura.exception.NoEncontradoException;
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
