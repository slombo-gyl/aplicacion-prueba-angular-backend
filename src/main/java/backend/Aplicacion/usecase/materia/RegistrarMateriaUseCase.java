package backend.Aplicacion.usecase.materia;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.RegistrarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrarMateriaUseCase implements RegistrarMateria {

    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public MateriaModel guardar(MateriaModel materia) {
        return materiaRepositoryPort.guardar(materia);
    }
}
