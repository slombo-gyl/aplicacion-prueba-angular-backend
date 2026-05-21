package backend.infraestructura.controladores;

import backend.aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.aplicacion.usecases.puntaje.ObtenerPuntajesUseCase;
import backend.aplicacion.usecases.puntaje.RegistrarPuntajeUseCase;
import backend.dominio.modelos.PuntajeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PuntajeController {
    private final ObtenerPuntajesUseCase obtenerPuntajes;
    private final RegistrarPuntajeUseCase registrarPuntaje;

    @GetMapping("/chart")
    public ResponseEntity<PuntajeDTOResponse> getChart() {
        PuntajeDTOResponse chart = obtenerPuntajes.ejecutar();

        return ResponseEntity.ok(chart);
    }

    @PostMapping
    public ResponseEntity<PuntajeModel> registrar(@RequestBody PuntajeDTORequest request) {
        PuntajeModel puntaje = registrarPuntaje.ejecutar(request);

        return ResponseEntity.ok(puntaje);
    }
}