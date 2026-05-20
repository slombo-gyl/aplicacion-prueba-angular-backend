package backend.Aplicacion.usecases.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.mappers.materiaMapper.MateriaDTOMapper;
import backend.Dominio.puertos.in.materia.BuscarMateriaPorIdUseCase;
import backend.Dominio.puertos.out.materia.MateriaModelPort;
import backend.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarMateriaPorIdUseCaseImpl implements BuscarMateriaPorIdUseCase {

    private final MateriaModelPort repository;

    @Override
    public MateriaResponseDTO ejecutar(Long id) {
        return repository.buscarActivaPorId(id)
                .map(MateriaDTOMapper::toDTOResponse)
                .orElseThrow(()-> new NoEncontradoException("Materia no encontrada"));
    }
}
