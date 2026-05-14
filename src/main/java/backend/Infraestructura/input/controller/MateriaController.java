package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Aplicacion.usecase.materia.deshabilitar.DeshabilitarMateriaUseCase;
import backend.Aplicacion.usecase.materia.registrar.RegistrarMateriaUseCase;
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
    private final RegistrarMateriaUseCase registrarMateriaUseCase;
    private final DeshabilitarMateriaUseCase deshabilitarMateriaUseCase;

    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody RegistrarMateriaDTORequest req){
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