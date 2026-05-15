package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.estudiante.ActualizarEstudianteDTORequest;
import backend.Aplicacion.dto.estudiante.BajaEstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.estudiante.RegistrarEstudianteDTORequest;
import backend.Aplicacion.usecase.estudiante.actualizar.ActualizarEstudianteUseCase;
import backend.Aplicacion.usecase.estudiante.registrar.RegistrarEstudianteUseCase;
import backend.Dominio.puertos.in.Student.ActualizarEstudiante;
import backend.Dominio.puertos.in.Student.BajaEstudiante;
import backend.Dominio.puertos.in.Student.RegistrarEstudiante;
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

    private final RegistrarEstudiante registrarEstudiante;
    private final ActualizarEstudiante actualizarEstudiante;
    private final BajaEstudiante bajaEstudiante;

    @PostMapping
    public ResponseEntity<EstudianteDTOResponse> crearEstudiante(@Valid @RequestBody RegistrarEstudianteDTORequest dto) {
        EstudianteDTOResponse estudianteResponse = registrarEstudiante.ejecutar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EstudianteDTOResponse> actualizarEstudiante(@PathVariable Long id, @Valid @RequestBody ActualizarEstudianteDTORequest dto) {
        EstudianteDTOResponse estudianteResponse = actualizarEstudiante.ejecutar(id, dto);
        return ResponseEntity.ok(estudianteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BajaEstudianteDTOResponse> darBaja(@PathVariable Long id) {
        return ResponseEntity.ok(bajaEstudiante.ejecutar(id));
    }
}
