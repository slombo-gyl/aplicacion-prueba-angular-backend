package backend.Dominio.modelo;

import backend.Dominio.modelo.enums.Estado;

public class Materia {

    private Long id;
    private String nombre;
    private int puntaje;
    private Estado estado = Estado.ACTIVO;

    public Materia(Long id, String nombre, int puntaje, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.estado = estado;
    }

    public Materia() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
