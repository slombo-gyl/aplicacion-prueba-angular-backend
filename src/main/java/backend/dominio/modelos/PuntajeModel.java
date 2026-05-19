package backend.dominio.modelos;

public class PuntajeModel {
    private Long id;
    private double valor;
    private EstudianteModel estudiante;
    private MateriaModel materia;

    public PuntajeModel(){}

    public PuntajeModel(Integer valor, EstudianteModel estudiante, MateriaModel materia) {
        this.valor = valor;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public EstudianteModel getEstudiante() {
        return estudiante;
    }

    public MateriaModel getMateria() {
        return materia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setEstudiante(EstudianteModel estudiante) {
        this.estudiante = estudiante;
    }

    public void setMateria(MateriaModel materia) {
        this.materia = materia;
    }

    public void validar() {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 10");
        }
    }
}