package backend.Infraestructura.controller;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Dominio.puertos.in.student.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EstudianteController {

    private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final ActualizarEstudianteUseCase actualizarEstudianteUseCase;
    private final BajaEstudianteUseCase bajaEstudianteUseCase;
    private final ListarTodosLosEstudiantesUseCase listarTodosLosEstudiantesUseCase;
    private final ReactivarEstudianteUseCase reactivarEstudianteUseCase;
    private final BuscarEstudiantePorIdUseCase buscarEstudiantePorIdUseCase;

    @PostMapping
    public ResponseEntity<EstudianteDTOResponse> crearEstudiante(@Valid @RequestBody RegistrarEstudianteDTORequest dto) {
        EstudianteDTOResponse estudianteResponse = registrarEstudianteUseCase.registrarEstudianteUseCase(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteResponse);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTOResponse>> listarEstudiantes() {
        List<EstudianteDTOResponse> estudiantes = listarTodosLosEstudiantesUseCase.listarTodosLosEstudiantesUseCase();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> obtenerEstudiantePorId(@PathVariable Long id) {
        EstudianteDTOResponse estudiante = buscarEstudiantePorIdUseCase.buscarEstudiantePorIdUseCase(id);
        return ResponseEntity.ok(estudiante);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> actualizarEstudiante(@PathVariable Long id, @Valid @RequestBody ActualizarEstudianteDTORequest dto) {
        EstudianteDTOResponse estudianteResponse = actualizarEstudianteUseCase.actualizarEstudianteUseCase(id, dto);
        return ResponseEntity.ok(estudianteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoEstudianteDTOResponse> darBaja(@PathVariable Long id) {
        return ResponseEntity.ok(bajaEstudianteUseCase.bajaEstudianteUseCase(id));
    }

    @PatchMapping("/reactivar/{id}")
    public ResponseEntity<EstadoEstudianteDTOResponse> reactivar(@PathVariable Long id) {
        return ResponseEntity.ok(reactivarEstudianteUseCase.reactivarEstudianteUseCase(id));
    }
}
