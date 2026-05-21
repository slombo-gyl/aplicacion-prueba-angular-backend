package backend.infraestructura.controllers;

import backend.aplicacion.dto.puntaje.MateriaNotasDTOResponse;
import backend.aplicacion.dto.puntaje.ObtenerPuntajesDTOResponse;
import backend.aplicacion.dto.puntaje.RegistrarPuntajeDTORequest;
import backend.dominio.modelo.Puntaje;
import backend.dominio.puertos.in.puntaje.ObtenerPuntajesPorEstudianteUseCase;
import backend.dominio.puertos.in.puntaje.ObtenerPuntajesUseCase;
import backend.dominio.puertos.in.puntaje.RegistrarPuntajeUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PuntajeController {


    private final ObtenerPuntajesUseCase obtenerPuntajes;
    private final RegistrarPuntajeUseCase registrarPuntaje;
    private final ObtenerPuntajesPorEstudianteUseCase obtenerPuntajesPorEstudiante;


    @GetMapping("/chart")
    public ResponseEntity<ObtenerPuntajesDTOResponse> getChart() {
        ObtenerPuntajesDTOResponse chart = obtenerPuntajes.ejecutar();
        return ResponseEntity.ok(chart);
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<MateriaNotasDTOResponse>> obtenerPorEstudiante(@PathVariable Long id) {
        List<MateriaNotasDTOResponse> puntajes = obtenerPuntajesPorEstudiante.ejecutar(id);
        return ResponseEntity.ok(puntajes);
    }

    @PostMapping
    public ResponseEntity<Puntaje> registrar(@Valid @RequestBody RegistrarPuntajeDTORequest request) {
        Puntaje puntaje = registrarPuntaje.ejecutar(request);
        return ResponseEntity.ok(puntaje);
    }
}
