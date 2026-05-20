package backend.aplicacion.usecases.materia;

import backend.dominio.modelo.Materia;
import backend.dominio.modelo.enums.Estado;
import backend.dominio.puertos.in.materia.RestaurarMateriaUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class RestaurarMateriaUseCaseImpl implements RestaurarMateriaUseCase {
    private final MateriaModelPort materiaModelPort;

    @Override
    public Materia ejecutar(Long id) {
        Materia materia = materiaModelPort.buscarPorId(id)
                .orElseThrow(() -> new NoEncontradoException(
                        "No se ha encontrado la materia con el id " + id
                ));
        Assert.isTrue(materia.getEstado() == Estado.INACTIVO, "La materia ya se encuentra activa");
        materia.setEstado(Estado.ACTIVO);
        return materiaModelPort.guardar(materia);
    }
}
