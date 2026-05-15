package backend.Infraestructura.input.controller;

import backend.Aplicacion.dto.materia.ModificarMateriaDTORequest;
import backend.Aplicacion.dto.materia.ModificarMateriaDTOResponse;
import backend.Aplicacion.dto.materia.RegistrarMateriaDTORequest;
import backend.Dominio.puertos.in.materia.ModificarMateria;
import backend.Dominio.puertos.in.materia.RegistrarMateria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/materias")
@RequiredArgsConstructor
@CrossOrigin(origins= "*")
public class MateriaController {

    private final RegistrarMateria registrarMateriaUse;
    private final ModificarMateria modificarMateriaUse;


    @PostMapping
    public ResponseEntity<Long> creaMateria(@RequestBody RegistrarMateriaDTORequest req){
        Long id = registrarMateriaUse.ejecutar(req);
        return  ResponseEntity.ok(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ModificarMateriaDTOResponse> modificarMateria(@PathVariable Long id , @RequestBody ModificarMateriaDTORequest req)
    {
        ModificarMateriaDTOResponse response = modificarMateriaUse.ejecutar(id,req);
        return ResponseEntity.ok(response);
    }

}
