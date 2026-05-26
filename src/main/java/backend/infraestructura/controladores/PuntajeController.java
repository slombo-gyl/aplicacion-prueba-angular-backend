package backend.infraestructura.controladores;

import backend.aplicacion.dto.chart.ChartDTOResponse;
import backend.aplicacion.dto.puntaje.PuntajeDTORequest;
import backend.aplicacion.dto.puntaje.PuntajeDTOResponse;
import backend.aplicacion.usecases.puntaje.ObtenerChartUseCase;
import backend.aplicacion.usecases.puntaje.RegistrarPuntajeUseCase;
import backend.dominio.puertos.in.puntaje.ObtenerListaPuntajesUseCase;
import backend.dominio.puertos.in.puntaje.ObtenerPuntajeSegunEstudianteYMateriaUseCase;
import backend.dominio.puertos.in.puntaje.ObtenerPuntajesDeEstudianteUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/puntajes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PuntajeController {
    private final ObtenerChartUseCase obtenerPuntajes;
    private final RegistrarPuntajeUseCase registrarPuntaje;
    private final ObtenerListaPuntajesUseCase obtenerListaPuntajesUseCase;
    private final ObtenerPuntajesDeEstudianteUseCase obtenerPuntajesDeEstudianteUseCase;
    private final ObtenerPuntajeSegunEstudianteYMateriaUseCase obtenerPuntajeSegunEstudianteYMateriaUseCase;
    @GetMapping("/chart")
    public ResponseEntity<ChartDTOResponse> getChart() {
        ChartDTOResponse chart = obtenerPuntajes.ejecutar();

        return ResponseEntity.ok(chart);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PuntajeDTOResponse>> listarTodoElRegistro() {
        return ResponseEntity.ok(obtenerListaPuntajesUseCase.ejecutar());
    }

    @GetMapping("/{estudianteId}/{materiaId}")
    public ResponseEntity<PuntajeDTOResponse> obtenerPorEstudianteYMateria(@Valid @PathVariable Long estudianteId, @Valid @PathVariable Long materiaId) {
        PuntajeDTOResponse puntaje = obtenerPuntajeSegunEstudianteYMateriaUseCase.ejecutar(estudianteId,materiaId);

        return ResponseEntity.ok(puntaje);
    }

    @GetMapping("/{estudianteId}")
    public ResponseEntity<List<PuntajeDTOResponse>> obtenerPorEstudiante(@Valid @PathVariable Long estudianteId){
        return ResponseEntity.ok(obtenerPuntajesDeEstudianteUseCase.ejecutar(estudianteId));

    }

    @PostMapping
    public ResponseEntity<PuntajeDTOResponse> registrar(@Valid @RequestBody PuntajeDTORequest request){
        PuntajeDTOResponse registrado = registrarPuntaje.ejecutar(request);

        return ResponseEntity.ok(registrado);
    }
}