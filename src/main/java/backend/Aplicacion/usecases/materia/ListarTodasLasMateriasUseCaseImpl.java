package backend.Aplicacion.usecases.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.mappers.materiaMapper.MateriaDTOMapper;
import backend.Dominio.puertos.in.materia.ListarTodasLasMateriasUseCase;
import backend.Dominio.puertos.out.materia.MateriaModelPort;
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