package backend.Aplicacion.usecase.materia.listar;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Dominio.puertos.in.materia.ListarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarMateriaUseCase {

    private final MateriaRepositoryPort materiaRepositoryPort;



}
