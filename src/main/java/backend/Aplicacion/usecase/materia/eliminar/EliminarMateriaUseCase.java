package backend.Aplicacion.usecase.materia.eliminar;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.in.materia.EliminarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EliminarMateriaUseCase implements EliminarMateria {
    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public MateriaModel ejecutar(Long id) {
        MateriaModel materia = materiaRepositoryPort.buscarActivaPorId(id)
                .orElseThrow(() -> new NoEncontradoException(
                        "No se ha encontrado la materia con el id " + id
                ));
        materia.setEstado(Estado.INACTIVO);
        return materiaRepositoryPort.guardar(materia);
    }
}
