package backend.Aplicacion.usecase.materia.registrar;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Aplicacion.mapper.materiaMapper.MateriaMapper;
import backend.Dominio.modelo.Materia;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarMateriaUseCase implements backend.Dominio.puertos.in.materia.RegistrarMateriaUseCase {

   private final MateriaRepositoryPort materiaRepositoryPortepository;

    @Override
    public MateriaResponseDTO ejecutar(RegistrarMateriaDTORequest req) {
        Materia materia = new Materia();
        materia.setNombre(req.nombre());

        Materia materiaGuardada = materiaRepositoryPortepository.guardar(materia);
       return MateriaMapper.toDTOResponse(materiaGuardada);
    }


}
