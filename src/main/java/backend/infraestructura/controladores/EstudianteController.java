package backend.infraestructura.controladores;

import backend.aplicacion.dto.estudiante.EstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.dominio.puertos.in.estudiante.ActualizarEstudianteUseCase;
import backend.dominio.puertos.in.estudiante.DeshabilitarEstudianteUseCase;
import backend.dominio.puertos.in.estudiante.ObtenerEstudiantesUseCase;
import backend.dominio.puertos.in.estudiante.RegistrarEstudianteUseCase;
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
    private final ObtenerEstudiantesUseCase obtenerEstudiantesUseCase;
    private final DeshabilitarEstudianteUseCase deshabilitarEstudianteUseCase;
    private final ActualizarEstudianteUseCase actualizarEstudianteUseCase;

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