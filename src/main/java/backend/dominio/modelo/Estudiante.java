package backend.dominio.modelo;

import backend.dominio.modelo.enums.Estado;

public class Estudiante {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Estado estado = Estado.ACTIVO;

    public Estudiante(Long id, String nombre, String apellido, String email, String dni, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.estado = estado;
    }

    public Estudiante() {

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
