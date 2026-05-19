package backend.infraestructura.controladores;

import backend.aplicacion.usecases.puntaje.ObtenerPuntajesUseCaseImpl;
import backend.aplicacion.usecases.puntaje.RegistrarPuntajeUseCaseImpl;
import backend.dominio.modelos.PuntajeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PuntajeController {
    private final ObtenerPuntajesUseCaseImpl obtenerPuntajes;
    private final RegistrarPuntajeUseCaseImpl registrarPuntaje;

    @GetMapping("/chart")
    public ResponseEntity<backend.aplicacion.dto.puntaje.PuntajeDTOResponse> getChart() {
        backend.aplicacion.dto.puntaje.PuntajeDTOResponse chart = obtenerPuntajes.ejecutar();
        return ResponseEntity.ok(chart);
    }

    @PostMapping
    public ResponseEntity<PuntajeModel> registrar(@RequestBody backend.aplicacion.dto.puntaje.PuntajeDTORequest request) {
        PuntajeModel puntaje = registrarPuntaje.ejecutar(request);
        return ResponseEntity.ok(puntaje);
    }
}