package backend.infraestructura.controladores;

import backend.aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.dominio.puertos.in.estudiante.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteController {
    private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final ObtenerEstudiantePorIDUseCase obtenerEstudiantePorIDUseCase;
    private final ObtenerListaEstudiantesUseCase obtenerListaEstudiantesUseCase;
    private final DeshabilitarEstudianteUseCase deshabilitarEstudianteUseCase;
    private final ActualizarEstudianteUseCase actualizarEstudianteUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> crearEstudiante(@RequestBody EstudianteDTORequest req) {
        Long id = registrarEstudianteUseCase.ejecutar(req);
        return ResponseEntity.ok(id);
    }

    @GetMapping("buscar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EstudianteDTOResponse> consultarEstudiante(@PathVariable Long id){
        return ResponseEntity.ok(obtenerEstudiantePorIDUseCase.ejecutar(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EstudianteDTOResponse>> listarEstudiantes() {
        return ResponseEntity.ok(obtenerListaEstudiantesUseCase.ejecutar(true));
    }

    @GetMapping("/inactivos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EstudianteDTOResponse>> listarEstudiantesInactivos() {
        return ResponseEntity.ok(obtenerListaEstudiantesUseCase.ejecutar(false));
    }

    @GetMapping("/todo")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EstudianteDTOResponse>> listarTodoElRegistro() {
        return ResponseEntity.ok(obtenerListaEstudiantesUseCase.ejecutar());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EstudianteDTOResponse> actualizarEstudiante(@Valid @PathVariable Long id, @RequestBody EstudianteDTORequest req){
        return ResponseEntity.ok(actualizarEstudianteUseCase.ejecutar(id,req));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LocalDateTime> deshabilitarEstudiante(@Valid @PathVariable Long id) {
        LocalDateTime fechaBaja = deshabilitarEstudianteUseCase.ejecutar(id);

        return ResponseEntity.ok(fechaBaja);
    }
}