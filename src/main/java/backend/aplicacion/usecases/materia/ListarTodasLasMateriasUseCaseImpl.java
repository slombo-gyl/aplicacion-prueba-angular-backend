package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.mappers.materiaMapper.MateriaDTOMapper;
import backend.dominio.puertos.in.materia.ListarTodasLasMateriasUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodasLasMateriasUseCaseImpl implements ListarTodasLasMateriasUseCase {

    private final MateriaModelPort repository;

    @Override
    public List<MateriaResponseDTO> ejecutar() {
        return repository.obtenerTodasLasMateriasActivas().
                stream().map(MateriaDTOMapper::toDTOResponse).toList();
    }
}