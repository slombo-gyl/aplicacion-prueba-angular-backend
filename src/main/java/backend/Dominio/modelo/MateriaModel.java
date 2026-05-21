package backend.Dominio.modelo;

import java.time.LocalDateTime;

public class MateriaModel {

    private Long id;
    private String nombre;
    private boolean activo = true;
    private LocalDateTime deleteFecha;
    private LocalDateTime insertFecha;

    public MateriaModel() {
    }

    public MateriaModel(String nombre) {
        this.nombre = nombre;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getDeleteFecha() {
        return deleteFecha;
    }

    public void setDeleteFecha(LocalDateTime deleteFecha) {
        this.deleteFecha = deleteFecha;
    }

    public LocalDateTime getInsertFecha() {
        return insertFecha;
    }

    public void setInsertFecha(LocalDateTime insertFecha) {
        this.insertFecha = insertFecha;
    }

    @Override
    public String toString() {
        return "MateriaModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", activo=" + activo +
                ", deleteFecha=" + deleteFecha +
                ", insertFecha=" + insertFecha +
                '}';
    }
}
