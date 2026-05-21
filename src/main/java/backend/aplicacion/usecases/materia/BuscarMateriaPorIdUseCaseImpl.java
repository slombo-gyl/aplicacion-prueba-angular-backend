package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.mappers.materiaMapper.MateriaDTOMapper;
import backend.dominio.puertos.in.materia.BuscarMateriaPorIdUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarMateriaPorIdUseCaseImpl implements BuscarMateriaPorIdUseCase {
    private final MateriaModelPort repository;
    private final MateriaDTOMapper mapper;

    @Override
    public MateriaResponseDTO ejecutar(Long id) {
        return repository.buscarActivaPorId(id)
                .map(mapper::toDto)
                .orElseThrow(()-> new NoEncontradoException("Materia no encontrada"));
    }
}
