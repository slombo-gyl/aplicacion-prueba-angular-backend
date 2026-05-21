package backend.Aplicacion.usecase.materia;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.ActualizarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.exceptions.GenericNoContentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActualizarMateriaUseCase implements ActualizarMateria {

    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public MateriaModel actualizar(MateriaModel materia) {
        MateriaModel materiaExistente = materiaRepositoryPort.buscarPorId(materia.getId())
                .orElseThrow(() -> new GenericNoContentException("Materia no encontrada"));

        materiaExistente.setNombre(materia.getNombre());
        return materiaRepositoryPort.guardar(materiaExistente);
    }
}
