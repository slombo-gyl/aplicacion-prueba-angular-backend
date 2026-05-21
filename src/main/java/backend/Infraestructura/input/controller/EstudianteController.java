package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.Aplicacion.services.estudiante.EstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EstudianteController {

    //private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<Long> crearEstudiante(@Valid @RequestBody EstudianteDTORequest req) {
        Long id = estudianteService.registrar(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
