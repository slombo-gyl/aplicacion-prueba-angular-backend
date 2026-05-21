package backend.Aplicacion.usecase.materia;

import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.BorrarMateria;
import backend.Dominio.puertos.out.materia.MateriaRepositoryPort;
import backend.Infraestructura.exceptions.GenericNoContentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@AllArgsConstructor
public class BorrarMateriaUseCase implements BorrarMateria {

    private final MateriaRepositoryPort materiaRepositoryPort;

    @Override
    public MateriaModel borrado(Long id) {
        MateriaModel materia = materiaRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new GenericNoContentException("Materia no encontrada"));

        materia.setActivo(false);
        materia.setDeleteFecha(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
        return materiaRepositoryPort.guardar(materia);
    }
}
