package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.MateriaDTORequest;
import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.services.materia.MateriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {

    private final MateriaService materiaService;

    @PostMapping
    public ResponseEntity<MateriaResponseDTO> creaMateria(@Valid @RequestBody MateriaDTORequest req){
        return ResponseEntity.ok(materiaService.create(req));
    }

    @GetMapping
    public ResponseEntity<List<MateriaResponseDTO>> listarMaterias() {
        return ResponseEntity.ok(materiaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> buscarMateriaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.getById(id));
    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<MateriaResponseDTO> buscarMateriaPorNombre(@PathVariable String name) {
        return ResponseEntity.ok(materiaService.getByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> actualizarMateria(
            @PathVariable Long id,
            @Valid @RequestBody MateriaDTORequest req
    ) {
        return ResponseEntity.ok(materiaService.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> borrarMateria(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.delete(id));
    }
}
