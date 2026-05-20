package backend.dominio.modelo;



public class Puntaje {
    private Long id;
    private double valor;
    private Estudiante estudiante;
    private Materia materia;

    public Puntaje(Long id, double valor, Estudiante estudiante, Materia materia) {
        this.id = id;
        this.valor = valor;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public Puntaje() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
