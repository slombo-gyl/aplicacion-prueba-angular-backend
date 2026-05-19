package backend.aplicacion.usecases.materia;

import backend.dominio.modelos.MateriaModel;
import backend.dominio.puertos.in.materia.RegistrarMateriaUseCase;
import backend.dominio.puertos.out.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarMateriaUseCaseImpl implements RegistrarMateriaUseCase {
   private final MateriaModelPort materiaRepositoryPortepository;

    @Override
    public Long ejecutar(backend.aplicacion.dto.materia.MateriaDTORequest req) {
        MateriaModel materia = new MateriaModel();
        materia.setNombre(req.nombre());

        MateriaModel materiaGuardada = materiaRepositoryPortepository.guardar(materia);
       return materiaGuardada.getId();
    }
}