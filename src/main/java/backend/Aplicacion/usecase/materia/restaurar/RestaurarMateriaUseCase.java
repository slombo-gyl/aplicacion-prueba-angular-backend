package backend.Aplicacion.usecase.materia.restaurar;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.modelo.enums.Estado;
import backend.Dominio.puertos.in.materia.RestaurarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class RestaurarMateriaUseCase implements RestaurarMateria {
    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public MateriaModel ejecutar(Long id) {
        MateriaModel materia = materiaRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException(
                        "No se ha encontrado la materia con el id " + id
                ));
        Assert.isTrue(materia.getEstado() == Estado.INACTIVO, "La materia ya se encuentra activa");
        materia.setEstado(Estado.ACTIVO);
        return materiaRepositoryPort.guardar(materia);
    }
}
