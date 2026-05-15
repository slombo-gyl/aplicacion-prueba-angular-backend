package backend.Aplicacion.usecase.materia.listar;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Dominio.puertos.in.materia.ListarTodasLasMaterias;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodasLasMateriasUseCase implements ListarTodasLasMaterias {

    private final MateriaRepositoryPort repository;

    @Override
    public List<MateriaResponseDTO> ejecutar() {
        return repository.obtenerTodasLasMateriasActivas().
                stream().map(MateriaMapper::toDTOResponse).toList();
    }
}