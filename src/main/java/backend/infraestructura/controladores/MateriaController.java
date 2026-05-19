package backend.infraestructura.controladores;

import backend.aplicacion.dto.materia.MateriaDTORequest;
import backend.aplicacion.usecases.materia.DeshabilitarMateriaUseCaseImpl;
import backend.aplicacion.usecases.materia.RegistrarMateriaUseCaseImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {
    private final RegistrarMateriaUseCaseImpl registrarMateriaUseCase;
    private final DeshabilitarMateriaUseCaseImpl deshabilitarMateriaUseCase;

    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody MateriaDTORequest req){
        Long id = registrarMateriaUseCase.ejecutar(req);

        return  ResponseEntity.ok(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LocalDateTime> deshabilitarMateria(@Valid @PathVariable Long id) {
        LocalDateTime fechaBaja = deshabilitarMateriaUseCase.ejecutar(id);

        return ResponseEntity.ok(fechaBaja);
    }
}