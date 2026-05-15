package backend.Dominio.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MateriaModel {
    private Long id;
    private  String nombre;
    private LocalDateTime fechaBaja;

    public MateriaModel(String nombre){
        this.nombre = nombre;
    }
}