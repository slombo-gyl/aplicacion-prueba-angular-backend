package backend.aplicacion.usecases.materia;

import backend.dominio.modelo.Materia;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.materia.EliminarMateriaUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.Infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EliminarMateriaUseCaseImpl implements EliminarMateriaUseCase {
    private final MateriaModelPort materiaModelPort;

    @Override
    public Materia ejecutar(Long id) {
        Materia materia = materiaModelPort.buscarActivaPorId(id)
                .orElseThrow(() -> new NoEncontradoException(
                        "No se ha encontrado la materia con el id " + id
                ));
        materia.setEstado(Estado.INACTIVO);
        return materiaModelPort.guardar(materia);
    }
}
