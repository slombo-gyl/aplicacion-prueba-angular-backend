package backend.Aplicacion.usecase.estudiante.reactivar;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.Infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReactivarEstudianteUseCase implements backend.Dominio.puertos.in.Student.ReactivarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public EstadoEstudianteDTOResponse ejecutar(Long id) {
        Estudiante estudiante = repository.obtenerPorId(id)
                .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));

        estudiante.setEstado(Estado.ACTIVO);
        repository.guardar(estudiante);

        return new EstadoEstudianteDTOResponse(estudiante.getId(), "El estudiante fue dado de reactivado");
    }
}
