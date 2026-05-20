package backend.Aplicacion.usecase.materia.restaurar;

import backend.Dominio.modelo.Materia;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.in.materia.RestaurarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class RestaurarMateriaUseCase implements RestaurarMateria {
    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public Materia ejecutar(Long id) {
        Materia materia = materiaRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoEncontradoException(
                        "No se ha encontrado la materia con el id " + id
                ));
        Assert.isTrue(materia.getEstado() == Estado.INACTIVO, "La materia ya se encuentra activa");
        materia.setEstado(Estado.ACTIVO);
        return materiaRepositoryPort.guardar(materia);
    }
}
