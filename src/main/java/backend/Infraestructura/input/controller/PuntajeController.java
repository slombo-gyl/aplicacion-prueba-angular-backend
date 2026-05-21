package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.Aplicacion.dto.puntaje.PuntajesDTOResponse;
import backend.Aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.Aplicacion.usecase.puntaje.ObtenerPuntajes;
import backend.Aplicacion.usecase.puntaje.RegistrarPuntaje;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PuntajeController {


    private final ObtenerPuntajes obtenerPuntajes;
    private final RegistrarPuntaje registrarPuntaje;


    @GetMapping("/chart")
    public ResponseEntity<PuntajesDTOResponse> getChart() {
        PuntajesDTOResponse chart = obtenerPuntajes.ejecutar();
        return ResponseEntity.ok(chart);
    }

    @PostMapping
    public ResponseEntity<PuntajeDTOResponse> registrar(@RequestBody PuntajeDTORequest request) {
        PuntajeDTOResponse puntaje = registrarPuntaje.ejecutar(request);
        return ResponseEntity.ok(puntaje);
    }
}
