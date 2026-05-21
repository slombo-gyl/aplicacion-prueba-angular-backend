package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.aplicacion.mappers.materiaMapper.MateriaDTOMapper;
import backend.dominio.modelo.Materia;
import backend.dominio.puertos.in.materia.RegistrarMateriaUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarMateriaUseCaseImpl implements RegistrarMateriaUseCase {
   private final MateriaModelPort materiaModelPortepository;
    private final MateriaDTOMapper mapper;

    @Override
    public MateriaResponseDTO ejecutar(RegistrarMateriaDTORequest req) {
        Materia materia = new Materia();
        materia.setNombre(req.nombre());

        Materia materiaGuardada = materiaModelPortepository.guardar(materia);
       return mapper.toDto(materiaGuardada);
    }


}
