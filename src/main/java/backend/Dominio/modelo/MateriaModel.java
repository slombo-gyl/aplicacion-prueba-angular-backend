package backend.Dominio.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaModel {
    private Long id;
    private  String nombre;

    public MateriaModel(String nombre){
        this.nombre = nombre;
    }
}