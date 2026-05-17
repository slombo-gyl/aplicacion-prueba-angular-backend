package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.Aplicacion.dto.materia.ModificarMateriaDTOResponse;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {

    private final RegistrarMateria registrarMateria;
    private final ModificarMateria modificarMateria;
    private final EliminarMateria eliminarMateria;
    private final RestaurarMateria restaurarMateria;
    private final ListarTodasLasMaterias listarTodasLasMaterias;
    private final BuscarMateriaPorId buscarMateriaPorId;


    @PostMapping
    public ResponseEntity<MateriaResponseDTO> crearMateria(@RequestBody RegistrarMateriaDTORequest req){
        MateriaResponseDTO materia = registrarMateria.ejecutar(req);
        return  ResponseEntity.status(HttpStatus.CREATED).body(materia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> obtenerMateriaPorId(@PathVariable Long id){
        MateriaResponseDTO materia = buscarMateriaPorId.ejecutar(id);
        return ResponseEntity.ok(materia);
    }

    @GetMapping
    public ResponseEntity<List<MateriaResponseDTO>> listarMaterias(){
        List<MateriaResponseDTO> materias = listarTodasLasMaterias.ejecutar();
        return ResponseEntity.ok(materias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModificarMateriaDTOResponse> modificarMateria(@PathVariable Long id , @RequestBody ModificarMateriaDTORequest req)
    {
        ModificarMateriaDTOResponse response = modificarMateria.ejecutar(id,req);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MateriaModel> eliminarMateria(@PathVariable Long id) {
        MateriaModel materiaEliminada = eliminarMateria.ejecutar(id);
        return ResponseEntity.ok(materiaEliminada);
    }

    @PutMapping("/restaurar/{id}")
    public ResponseEntity<MateriaModel> restaurarMateria(@PathVariable Long id) {
        MateriaModel materiaRestaurada = restaurarMateria.ejecutar(id);
        return ResponseEntity.ok(materiaRestaurada);
    }
}
