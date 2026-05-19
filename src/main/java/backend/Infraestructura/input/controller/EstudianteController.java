package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Aplicacion.usecase.estudiante.deshabilitar.DeshabilitarEstudianteUseCase;
import backend.Aplicacion.usecase.estudiante.registrar.RegistrarEstudianteUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EstudianteController {
    private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final DeshabilitarEstudianteUseCase deshabilitarEstudianteUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> crearEstudiante(@RequestBody RegistrarEstudianteDTORequest req) {
        Long id = registrarEstudianteUseCase.ejecutar(req);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LocalDateTime> deshabilitarEstudiante(@Valid @PathVariable Long id) {
        LocalDateTime fechaBaja = deshabilitarEstudianteUseCase.ejecutar(id);

        return ResponseEntity.ok(fechaBaja);
    }

}