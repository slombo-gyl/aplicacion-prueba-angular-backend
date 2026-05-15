package backend.Dominio.modelo;

import backend.Dominio.modelo.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaModel {

    private Long id;
    private String nombre;
    private int puntaje;
    private Estado estado = Estado.ACTIVO;

    public MateriaModel(String nombre){
        this.nombre = nombre;
    }
}
