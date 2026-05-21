package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.dominio.modelo.Materia;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.materia.RegistrarMateriaUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.exception.ValidacionException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RegistrarMateriaUseCaseImpl implements RegistrarMateriaUseCase {

    private final MateriaModelPort repository;

    @Override
    public Materia registrarMateria(RegistrarMateriaDTORequest dto) {

        Map<String, List<String>> errors = new HashMap<>();

        repository.findByNombre(dto.nombre())
                .ifPresent(materia -> errors.put("nombre", List.of("El nombre de la materia ya está registrado")));

        if (!errors.isEmpty()) {
            throw new ValidacionException(errors);
        }

        Materia nuevaMateria = new Materia();
        nuevaMateria.setNombre(dto.nombre());
        nuevaMateria.setPuntaje(0);
        nuevaMateria.setEstado(Estado.ACTIVO);

        return repository.guardar(nuevaMateria);
    }
}
