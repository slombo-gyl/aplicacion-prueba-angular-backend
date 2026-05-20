package backend.Aplicacion.usecases.materia;

import backend.Dominio.modelo.Materia;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.in.materia.EliminarMateriaUseCase;
import backend.Dominio.puertos.out.materia.MateriaModelPort;
import backend.shared.exception.NoEncontradoException;
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
