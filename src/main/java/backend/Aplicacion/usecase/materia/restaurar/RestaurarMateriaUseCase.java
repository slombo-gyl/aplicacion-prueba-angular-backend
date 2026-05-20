package backend.Aplicacion.usecase.materia.restaurar;

import backend.Dominio.modelo.Materia;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.out.materia.MateriaModelPort;
import backend.Infraestructura.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class RestaurarMateriaUseCase implements backend.Dominio.puertos.in.materia.RestaurarMateriaUseCase {
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
