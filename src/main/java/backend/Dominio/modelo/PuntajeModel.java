package backend.Dominio.modelo;



public class PuntajeModel {
    private Long id;
    private double valor;
    private EstudianteModel estudiante;
    private MateriaModel materia;

    public PuntajeModel(Long id, double valor, EstudianteModel estudiante, MateriaModel materia) {
        this.id = id;
        this.valor = valor;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public PuntajeModel() {

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

    public EstudianteModel getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteModel estudiante) {
        this.estudiante = estudiante;
    }

    public MateriaModel getMateria() {
        return materia;
    }

    public void setMateria(MateriaModel materia) {
        this.materia = materia;
    }
}
