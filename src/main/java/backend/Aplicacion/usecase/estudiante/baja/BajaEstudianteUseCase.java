package backend.Aplicacion.usecase.estudiante.baja;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.Dominio.modelo.Estudiante;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.Infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BajaEstudianteUseCase implements backend.Dominio.puertos.in.Student.BajaEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public EstadoEstudianteDTOResponse ejecutar(Long id) {
        Estudiante estudiante = repository.obtenerPorId(id)
                        .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));

        estudiante.setEstado(Estado.INACTIVO);
        repository.guardar(estudiante);

        return new EstadoEstudianteDTOResponse(estudiante.getId(), "El estudiante fue dado de baja");
    }
}