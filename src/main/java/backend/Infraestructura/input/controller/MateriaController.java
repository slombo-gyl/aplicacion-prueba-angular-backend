package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.estudiante.EstudianteDTOResponse;
import backend.Aplicacion.dto.materia.MateriaResponseDTO;
import backend.Aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.Aplicacion.dto.materia.ModificarMateriaDTOResponse;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.*;
import lombok.RequiredArgsConstructor;
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


    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody RegistrarMateriaDTORequest req){
        Long id = registrarMateria.ejecutar(req);
        return  ResponseEntity.ok(id);
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
