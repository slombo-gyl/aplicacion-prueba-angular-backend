package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.MateriaDTORequest;
import backend.aplicacion.dto.materia.MateriaDTOResponse;
import backend.aplicacion.mappers.MateriaMapper;
import backend.dominio.modelos.MateriaModel;
import backend.dominio.puertos.in.materia.ActualizarMateriaUseCase;
import backend.dominio.puertos.out.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActualizarMateriaUseCaseImpl implements ActualizarMateriaUseCase {
    private final MateriaModelPort repository;

    @Override
    public MateriaDTOResponse ejecutar(Long id, MateriaDTORequest req) {
        MateriaModel materiaActualizado = repository.buscarPorId(id);

        materiaActualizado.setNombre(req.nombre());

        repository.guardar(materiaActualizado);

        return MateriaMapper.toResponseDto(materiaActualizado);
    }
}