package backend.infraestructura.controllers;

import backend.aplicacion.dto.materia.MateriaResponseDTO;
import backend.aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.aplicacion.services.materia.MateriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor
public class MateriaController {

    private final MateriaService materiaService;

    @PostMapping
    public ResponseEntity<MateriaResponseDTO> registrarMateria(@Valid @RequestBody RegistrarMateriaDTORequest request) {
        MateriaResponseDTO nuevaMateria = materiaService.registrar(request);
        return new ResponseEntity<>(nuevaMateria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MateriaResponseDTO>> listarTodasLasMaterias() {
        List<MateriaResponseDTO> materias = materiaService.listarTodasLasMaterias();
        return ResponseEntity.ok(materias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> buscarMateriaPorId(@PathVariable Long id) {
        MateriaResponseDTO materia = materiaService.buscarPorId(id);
        return ResponseEntity.ok(materia);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> actualizarMateria(
            @PathVariable Long id,
            @Valid @RequestBody ModificarMateriaDTORequest request) {
        MateriaResponseDTO materiaActualizada = materiaService.actualizar(id, request);
        return ResponseEntity.ok(materiaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> darDeBajaMateria(@PathVariable Long id) {
        MateriaResponseDTO materiaEliminada = materiaService.eliminar(id);
        return ResponseEntity.ok(materiaEliminada);
    }

    @PatchMapping("/reactivar/{id}")
    public ResponseEntity<MateriaResponseDTO> restaurarMateria(@PathVariable Long id) {
        MateriaResponseDTO materiaRestaurada = materiaService.restaurar(id);
        return ResponseEntity.ok(materiaRestaurada);
    }
}
