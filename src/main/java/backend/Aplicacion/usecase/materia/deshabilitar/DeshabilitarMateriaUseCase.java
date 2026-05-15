package backend.Aplicacion.usecase.materia.deshabilitar;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.DeshabilitarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DeshabilitarMateriaUseCase implements DeshabilitarMateria {
    private final MateriaRepositoryPort repository;

    @Override
    public LocalDateTime ejecutar(Long id) {
        MateriaModel materiaBuscada = repository.buscarPorId(id);

        materiaBuscada.setFechaBaja(LocalDateTime.now());

        repository.guardar(materiaBuscada);

        return materiaBuscada.getFechaBaja();
    }
}