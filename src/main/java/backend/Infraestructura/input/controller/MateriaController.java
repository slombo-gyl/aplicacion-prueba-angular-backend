package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.Aplicacion.dto.materia.ModificarMateriaDTOResponse;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Dominio.modelo.MateriaModel;
import backend.Dominio.puertos.in.materia.EliminarMateria;
import backend.Dominio.puertos.in.materia.ModificarMateria;
import backend.Dominio.puertos.in.materia.RegistrarMateria;
import backend.Dominio.puertos.in.materia.RestaurarMateria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {

    private final RegistrarMateria registrarMateria;
    private final ModificarMateria modificarMateria;
    private final EliminarMateria eliminarMateria;
    private final RestaurarMateria restaurarMateria;


    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody RegistrarMateriaDTORequest req){
        Long id = registrarMateria.ejecutar(req);
        return  ResponseEntity.ok(id);
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
