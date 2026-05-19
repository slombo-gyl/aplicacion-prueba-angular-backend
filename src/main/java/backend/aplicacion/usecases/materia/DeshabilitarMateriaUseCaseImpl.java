package backend.aplicacion.usecases.materia;

import backend.dominio.modelos.MateriaModel;
import backend.dominio.puertos.in.materia.DeshabilitarMateriaUseCase;
import backend.dominio.puertos.out.MateriaModelPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DeshabilitarMateriaUseCaseImpl implements DeshabilitarMateriaUseCase {
    private final MateriaModelPort repository;

    @Override
    public LocalDateTime ejecutar(Long id) {
        MateriaModel materiaBuscada = repository.buscarPorId(id);

        materiaBuscada.setFechaBaja(LocalDateTime.now());

        repository.guardar(materiaBuscada);

        return materiaBuscada.getFechaBaja();
    }
}