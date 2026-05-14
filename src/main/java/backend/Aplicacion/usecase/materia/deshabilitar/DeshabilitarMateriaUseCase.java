package backend.Aplicacion.usecase.materia.deshabilitar;

import backend.Dominio.puertos.in.materia.DeshabilitarMateria;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import backend.Infraestructura.output.persistencia.repository.materia.MateriaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DeshabilitarMateriaUseCase implements DeshabilitarMateria {
    private final MateriaJpaRepository repository;

    @Override
    public LocalDateTime ejecutar(Long id) {
        MateriaEntity materiaBuscada = repository.findById(id).orElseThrow(NoSuchElementException::new);

        LocalDateTime fechaBaja = LocalDateTime.now();

        materiaBuscada.setFechaBaja(fechaBaja);

        return fechaBaja;
    }
}