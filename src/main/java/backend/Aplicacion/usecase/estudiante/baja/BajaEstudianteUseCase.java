package backend.Aplicacion.usecase.estudiante.baja;

import backend.Aplicacion.dto.estudiante.BajaEstudianteDTOResponse;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.in.Student.BajaEstudiante;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BajaEstudianteUseCase implements BajaEstudiante {
    private final EstudianteRepositoryPort repository;

    @Override
    public BajaEstudianteDTOResponse ejecutar(Long id) {
        EstudianteModel estudiante = repository.obtenerPorId(id)
                        .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        estudiante.setEstado(Estado.INACTIVO);
        repository.guardar(estudiante);

        return new BajaEstudianteDTOResponse(estudiante.getId(), "El estudiante fue dado de baja");
    }
}