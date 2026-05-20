package backend.Aplicacion.usecases.materia;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Aplicacion.mappers.materiaMapper.MateriaDTOMapper;
import backend.Dominio.modelo.Materia;
import backend.Dominio.puertos.in.materia.RegistrarMateriaUseCase;
import backend.Dominio.puertos.out.materia.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarMateriaUseCaseImpl implements RegistrarMateriaUseCase {

   private final MateriaModelPort materiaModelPortepository;

    @Override
    public MateriaResponseDTO ejecutar(RegistrarMateriaDTORequest req) {
        Materia materia = new Materia();
        materia.setNombre(req.nombre());

        Materia materiaGuardada = materiaModelPortepository.guardar(materia);
       return MateriaDTOMapper.toDTOResponse(materiaGuardada);
    }


}
