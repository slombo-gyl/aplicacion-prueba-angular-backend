package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.Aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.Aplicacion.services.puntaje.PuntajeService;
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

    private final PuntajeService puntajeService;

    @PostMapping
    public ResponseEntity<PuntajeDTOResponse> registrar(@Valid @RequestBody PuntajeDTORequest request) {
        return ResponseEntity.ok(puntajeService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PuntajeDTOResponse>> listarPorEstudiante() {
        return ResponseEntity.ok(puntajeService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PuntajeDTOResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PuntajeDTORequest request
    ) {
        return ResponseEntity.ok(puntajeService.update(id, request));
    }
}
