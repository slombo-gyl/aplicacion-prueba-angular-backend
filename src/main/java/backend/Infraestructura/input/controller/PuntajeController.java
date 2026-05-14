package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.Aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.Aplicacion.usecase.puntaje.obtener.ObtenerPuntajesUseCase;
import backend.Aplicacion.usecase.puntaje.registrar.RegistrarPuntajeUseCase;
import backend.Dominio.modelo.PuntajeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PuntajeController {


    private final ObtenerPuntajesUseCase obtenerPuntajes;
    private final RegistrarPuntajeUseCase registrarPuntaje;


    @GetMapping("/chart")
    public ResponseEntity<ObtenerPuntajesDTOResponse> getChart() {
        ObtenerPuntajesDTOResponse chart = obtenerPuntajes.ejecutar();
        return ResponseEntity.ok(chart);
    }

    @PostMapping
    public ResponseEntity<PuntajeModel> registrar(@RequestBody RegistrarPuntajeDTORequest request) {
        PuntajeModel puntaje = registrarPuntaje.ejecutar(request);
        return ResponseEntity.ok(puntaje);
    }
}
