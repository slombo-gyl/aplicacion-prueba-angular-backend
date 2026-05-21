package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.services.estudiante.EstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<EstudianteDTOResponse> crearEstudiante(
            @Valid @RequestBody EstudianteDTORequest req
    ) {
        return ResponseEntity.ok(estudianteService.create(req));
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTOResponse>> listarEstudiantes() {
        return ResponseEntity.ok(estudianteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> buscarEstudiantePorId(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.getById(id));
    }



    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> actualizarEstudiante(
            @PathVariable Long id,
            @Valid @RequestBody EstudianteDTORequest req
    ) {
        return ResponseEntity.ok(estudianteService.update(id, req));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> borrarEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.delete(id));
    }


    @PatchMapping("/alta/{id}")
    public ResponseEntity<EstudianteDTOResponse> activarEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.activar(id));
    }
}