package backend.infraestructura.controladores;

import backend.aplicacion.dto.materia.MateriaDTORequest;
import backend.aplicacion.dto.materia.MateriaDTOResponse;
import backend.aplicacion.usecases.materia.DeshabilitarMateriaUseCaseImpl;
import backend.aplicacion.usecases.materia.RegistrarMateriaUseCaseImpl;
import backend.dominio.puertos.in.materia.ActualizarMateriaUseCase;
import backend.dominio.puertos.in.materia.ObtenerListaMateriasUseCase;
import backend.dominio.puertos.in.materia.ObtenerMateriasUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MateriaController {
    private final RegistrarMateriaUseCaseImpl registrarMateriaUseCase;
    private final ObtenerMateriasUseCase obtenerMateriasUseCase;
    private final ObtenerListaMateriasUseCase obtenerListaMateriasUseCase;
    private final DeshabilitarMateriaUseCaseImpl deshabilitarMateriaUseCase;
    private final ActualizarMateriaUseCase actualizarMateriaUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> creaMateria(@RequestBody MateriaDTORequest req){
        Long id = registrarMateriaUseCase.ejecutar(req);

        return  ResponseEntity.ok(id);
    }

    @GetMapping("/buscar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MateriaDTOResponse> obtenerMateria(@PathVariable Long id){
        return ResponseEntity.ok(obtenerMateriasUseCase.ejecutar(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MateriaDTOResponse>> listarMaterias() {
        return ResponseEntity.ok(obtenerListaMateriasUseCase.ejecutar(true));
    }

    @GetMapping("/inactivos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MateriaDTOResponse>> listarMateriasInactivos() {
        return ResponseEntity.ok(obtenerListaMateriasUseCase.ejecutar(false));
    }

    @GetMapping("/todo")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MateriaDTOResponse>> listarTodoElRegistro() {
        return ResponseEntity.ok(obtenerListaMateriasUseCase.ejecutar());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MateriaDTOResponse> actualizarMateria(@Valid @PathVariable Long id, @RequestBody MateriaDTORequest req){
        return ResponseEntity.ok(actualizarMateriaUseCase.ejecutar(id,req));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LocalDateTime> deshabilitarMateria(@Valid @PathVariable Long id) {
        LocalDateTime fechaBaja = deshabilitarMateriaUseCase.ejecutar(id);

        return ResponseEntity.ok(fechaBaja);
    }
}