package backend.Infraestructura.controller;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Aplicacion.usecases.puntaje.ObtenerPuntajesImpl;
import backend.Aplicacion.usecases.puntaje.RegistrarPuntajeImpl;
import backend.Dominio.modelo.Puntaje;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PuntajeController {


    private final ObtenerPuntajesImpl obtenerPuntajesImpl;
    private final RegistrarPuntajeImpl registrarPuntajeImpl;


    @GetMapping("/chart")
    public ResponseEntity<ObtenerPuntajesDTOResponse> getChart() {
        ObtenerPuntajesDTOResponse chart = obtenerPuntajesImpl.ejecutar();
        return ResponseEntity.ok(chart);
    }

    @PostMapping
    public ResponseEntity<Puntaje> registrar(@Valid @RequestBody RegistrarPuntajeDTORequest request) {
        Puntaje puntaje = registrarPuntajeImpl.ejecutar(request);
        return ResponseEntity.ok(puntaje);
    }
}
