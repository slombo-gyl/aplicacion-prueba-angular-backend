package backend.aplicacion.usecases.materia;

import backend.aplicacion.dto.materia.EstudianteMateriaDTO;
import backend.aplicacion.dto.materia.MateriaDetalleResponseDTO;
import backend.dominio.modelo.Materia;
import backend.dominio.modelo.Puntaje;
import backend.dominio.puertos.in.materia.ListarMateriasConDetalleUseCase;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.dominio.puertos.out.puntaje.PuntajeModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarMateriasConDetalleUseCaseImpl implements ListarMateriasConDetalleUseCase {
    private final MateriaModelPort materiaModelPort;
    private final PuntajeModelPort puntajeModelPort;

    @Override
    public List<MateriaDetalleResponseDTO> listarMateriasConDetalle() {
        List<Materia> materias = materiaModelPort.obtenerTodasLasMateriasActivas();

        return materias.stream().map(materia -> {
            List<Puntaje> puntajes = puntajeModelPort.obtenerPorMateriaId(materia.getId());

            List<EstudianteMateriaDTO> alumnos = puntajes.stream().map(p ->
                    new EstudianteMateriaDTO(
                            p.getEstudiante().getId(),
                            p.getEstudiante().getNombre(),
                            p.getEstudiante().getApellido(),
                            p.getValor()
                    )
            ).toList();

            Double promedio = puntajes.isEmpty() ? null :
                    puntajes.stream()
                    .mapToDouble(Puntaje::getValor)
                    .average()
                    .orElse(0.0);

            if (promedio != null) {
                promedio = Math.round(promedio * 100.0) / 100.0;
            }

            return new MateriaDetalleResponseDTO(
                    materia.getId(),
                    materia.getNombre(),
                    promedio,
                    alumnos
            );
        }).toList();
    }
}
