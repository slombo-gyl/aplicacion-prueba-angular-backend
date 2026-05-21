package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.MateriaDTOResponse;
import backend.aplicacion.mappers.MateriaMapper;
import backend.dominio.puertos.in.materia.ObtenerListaMateriasUseCase;
import backend.dominio.puertos.out.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ObtenerListaMateriasUseCaseImpl implements ObtenerListaMateriasUseCase {
    private final MateriaModelPort repository;

    @Override
    public List<MateriaDTOResponse> ejecutar() {
        return repository.listar()
                .stream()
                .map(MateriaMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<MateriaDTOResponse> ejecutar(boolean activo) {
        return repository.listar(activo)
                .stream()
                .map(MateriaMapper::toResponseDto)
                .toList();
    }
}