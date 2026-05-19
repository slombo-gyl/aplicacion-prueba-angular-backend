package backend.dominio.modelos;

import java.time.LocalDateTime;

public class MateriaModel {
    private Long id;
    private String nombre;
    private LocalDateTime fechaBaja;

    public MateriaModel(String nombre){
        this.nombre = nombre;
    }

    public MateriaModel() {}

    public Long getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public LocalDateTime getFechaBaja()
    {
        return fechaBaja;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}