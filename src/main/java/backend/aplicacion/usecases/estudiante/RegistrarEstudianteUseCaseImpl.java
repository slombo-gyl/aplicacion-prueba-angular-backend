package backend.aplicacion.usecases.estudiante;

import backend.aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.dominio.modelos.EstudianteModel;
import backend.dominio.puertos.in.estudiante.RegistrarEstudianteUseCase;
import backend.dominio.puertos.out.EstudianteModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarEstudianteUseCaseImpl implements RegistrarEstudianteUseCase {
    private final EstudianteModelPort repository;

    @Override
    public Long ejecutar(EstudianteDTORequest req) {
        EstudianteModel student = new EstudianteModel();

        student.setNombre(req.nombre());
        student.setApellido(req.apellido());
        student.setEmail(req.email());
        student.setDni(req.dni());

        EstudianteModel saved = repository.guardar(student);

        return saved.getId();
    }
}