package backend.Aplicacion.usecase.materia.buscarPorId;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Dominio.puertos.in.materia.BuscarMateriaPorId;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarMateriaPorIdUseCase implements BuscarMateriaPorId {

    private final MateriaRepositoryPort repository;

    @Override
    public MateriaResponseDTO ejecutar(Long id) {
        return repository.buscarActivaPorId(id)
                .map(MateriaMapper::toDTOResponse)
                .orElseThrow(()-> new NoEncontradoException("Materia no encontrada"));
    }
}
