package backend.infraestructura.controladores;

import backend.aplicacion.dto.materia.MateriaDTORequest;
import backend.aplicacion.dto.materia.MateriaDTOResponse;
import backend.aplicacion.usecases.materia.DeshabilitarMateriaUseCaseImpl;
import backend.aplicacion.usecases.materia.RegistrarMateriaUseCaseImpl;
import backend.dominio.puertos.in.materia.ActualizarMateriaUseCase;
import backend.dominio.puertos.in.materia.ObtenerMateriasUseCase;
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
    private final ObtenerMateriasUseCase obtenerMateriasUseCase;
    private final DeshabilitarMateriaUseCaseImpl deshabilitarMateriaUseCase;
    private final ActualizarMateriaUseCase actualizarMateriaUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> creaMateria(@RequestBody MateriaDTORequest req){
        Long id = registrarMateriaUseCase.ejecutar(req);

        return  ResponseEntity.ok(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MateriaDTOResponse> obtenerMateria(Long id){
        return ResponseEntity.ok(obtenerMateriasUseCase.ejecutar(id));
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