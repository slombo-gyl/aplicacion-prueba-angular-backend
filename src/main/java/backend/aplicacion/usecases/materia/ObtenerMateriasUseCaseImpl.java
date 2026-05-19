package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.MateriaDTOResponse;
import backend.aplicacion.mappers.MateriaMapper;
import backend.dominio.puertos.in.materia.ObtenerMateriasUseCase;
import backend.dominio.puertos.out.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObtenerMateriasUseCaseImpl implements ObtenerMateriasUseCase {
    private final MateriaModelPort repository;

    @Override
    public MateriaDTOResponse ejecutar(Long id) {return MateriaMapper.toResponseDto(repository.buscarPorId(id));}
}