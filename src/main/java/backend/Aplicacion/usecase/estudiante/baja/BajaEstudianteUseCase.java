package backend.Aplicacion.usecase.estudiante.baja;

import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.in.Student.BajaEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BajaEstudianteUseCase implements BajaEstudiante {
    private final EstudianteRepositoryPort repository;

    @Override
    public EstadoEstudianteDTOResponse ejecutar(Long id) {
        EstudianteModel estudiante = repository.obtenerPorId(id)
                        .orElseThrow(() -> new NoEncontradoException("Estudiante no encontrado"));

        estudiante.setEstado(Estado.INACTIVO);
        repository.guardar(estudiante);

        return new EstadoEstudianteDTOResponse(estudiante.getId(), "El estudiante fue dado de baja");
    }
}