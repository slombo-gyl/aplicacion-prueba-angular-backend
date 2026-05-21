package backend.aplicacion.usecases.puntaje;

import backend.aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.dominio.modelo.Estudiante;
import backend.dominio.modelo.Materia;
import backend.dominio.modelo.Puntaje;
import backend.dominio.puertos.in.puntaje.RegistrarPuntajeUseCase;
import backend.dominio.puertos.out.estudiante.EstudianteModelPort;
import backend.dominio.puertos.out.materia.MateriaModelPort;
import backend.dominio.puertos.out.puntaje.PuntajeModelPort;
import backend.infraestructura.exception.NoEncontradoException;
import backend.infraestructura.exception.ValidarPuntajeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarPuntajeUseCaseImpl implements RegistrarPuntajeUseCase {

    private final PuntajeModelPort puntajeModelPort;
    private final EstudianteModelPort estudianteModelPort;
    private final MateriaModelPort materiaModelPort;

    @Override
    public Puntaje ejecutar(RegistrarPuntajeDTORequest req){
        validar(req.valor());

        Estudiante estudiante = estudianteModelPort.obtenerActivoPorId(req.estudianteId())
                .orElseThrow(() -> new NoEncontradoException(
                        "No se ha encontrado el estudiante con el id " + req.estudianteId()
                ));

        Materia materia = materiaModelPort.buscarActivaPorId(req.materiaId())
                .orElseThrow(() -> new NoEncontradoException(
                        "No se ha encontrado la materia con el id " + req.materiaId()
                ));

        Puntaje puntaje = new Puntaje();
        puntaje.setValor(req.valor());
        puntaje.setEstudiante(estudiante);
        puntaje.setMateria(materia);


        return puntajeModelPort.guardar(puntaje);
    }

    private void validar(Double valor) {
        if (valor < 0 || valor > 10) {
            throw new ValidarPuntajeException(
                    "El puntaje debe estar entre 0 y 10"
            );
        }
    }
}
