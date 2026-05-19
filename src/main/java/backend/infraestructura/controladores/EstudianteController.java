package backend.infraestructura.controladores;

import backend.aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.usecases.estudiante.DeshabilitarEstudianteUseCaseImpl;
import backend.aplicacion.usecases.estudiante.RegistrarEstudianteUseCaseImpl;
import backend.dominio.puertos.in.estudiante.ObtenerEstudiantesUseCase;
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
    private final RegistrarEstudianteUseCaseImpl registrarEstudianteUseCase;
    private final ObtenerEstudiantesUseCase obtenerEstudiantesUseCase;
    private final DeshabilitarEstudianteUseCaseImpl deshabilitarEstudianteUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> crearEstudiante(@RequestBody EstudianteDTORequest req) {
        Long id = registrarEstudianteUseCase.ejecutar(req);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<EstudianteDTOResponse> consultarEstudiante(Long id){
        return ResponseEntity.ok(obtenerEstudiantesUseCase.ejecutar(id));
        }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LocalDateTime> deshabilitarEstudiante(@Valid @PathVariable Long id) {
        LocalDateTime fechaBaja = deshabilitarEstudianteUseCase.ejecutar(id);

        return ResponseEntity.ok(fechaBaja);
    }
}