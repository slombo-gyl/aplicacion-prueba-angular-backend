package backend.Dominio.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaModel {

    private Long id;
    private String nombre;
    private boolean activo = true;


    public MateriaModel(String nombre){
        this.nombre = nombre;
    }
}
