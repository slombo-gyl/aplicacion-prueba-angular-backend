package backend.infraestructura.controllers;

import backend.aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.aplicacion.services.estudiante.EstudianteService;
import backend.dominio.puertos.in.student.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EstudianteController {
    private  final EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<EstudianteDTOResponse> crearEstudiante(@Valid @RequestBody RegistrarEstudianteDTORequest dto) {
        EstudianteDTOResponse estudianteResponse = estudianteService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteResponse);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTOResponse>> listarEstudiantes() {
        List<EstudianteDTOResponse> estudiantes = estudianteService.listarTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> obtenerEstudiantePorId(@PathVariable Long id) {
        EstudianteDTOResponse estudiante = estudianteService.buscarPorId(id);
        return ResponseEntity.ok(estudiante);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> actualizarEstudiante(@PathVariable Long id, @Valid @RequestBody ActualizarEstudianteDTORequest dto) {
        EstudianteDTOResponse estudianteResponse = estudianteService.actualizar(id, dto);
        return ResponseEntity.ok(estudianteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoEstudianteDTOResponse> darBaja(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.baja(id));
    }

    @PatchMapping("/reactivar/{id}")
    public ResponseEntity<EstadoEstudianteDTOResponse> reactivar(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.reactivar(id));
    }
}
