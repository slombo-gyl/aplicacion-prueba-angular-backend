package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.EstadoEstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Dominio.puertos.in.Student.*;
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

    private final RegistrarEstudiante registrarEstudiante;
    private final ActualizarEstudiante actualizarEstudiante;
    private final BajaEstudiante bajaEstudiante;
    private final ListarTodosLosEstudiantes listarTodosLosEstudiantes;
    private final ReactivarEstudiante reactivarEstudiante;
    private final BuscarEstudiantePorId buscarEstudiantePorId;

    @PostMapping
    public ResponseEntity<EstudianteDTOResponse> crearEstudiante(@Valid @RequestBody RegistrarEstudianteDTORequest dto) {
        EstudianteDTOResponse estudianteResponse = registrarEstudiante.ejecutar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteResponse);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTOResponse>> listarEstudiantes() {
        List<EstudianteDTOResponse> estudiantes = listarTodosLosEstudiantes.ejecutar();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> obtenerEstudiantePorId(@PathVariable Long id) {
        EstudianteDTOResponse estudiante = buscarEstudiantePorId.ejecutar(id);
        return ResponseEntity.ok(estudiante);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> actualizarEstudiante(@PathVariable Long id, @Valid @RequestBody ActualizarEstudianteDTORequest dto) {
        EstudianteDTOResponse estudianteResponse = actualizarEstudiante.ejecutar(id, dto);
        return ResponseEntity.ok(estudianteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoEstudianteDTOResponse> darBaja(@PathVariable Long id) {
        return ResponseEntity.ok(bajaEstudiante.ejecutar(id));
    }

    @PatchMapping("/reactivar/{id}")
    public ResponseEntity<EstadoEstudianteDTOResponse> reactivar(@PathVariable Long id) {
        return ResponseEntity.ok(reactivarEstudiante.ejecutar(id));
    }
}
