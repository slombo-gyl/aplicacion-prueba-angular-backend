package backend.Dominio.modelo;

import java.time.LocalDateTime;

public class PuntajeModel {
    private Long id;
    private double valor;
    private EstudianteModel estudiante;
    private MateriaModel materia;
    private LocalDateTime insertFecha;

    public PuntajeModel() {
    }

    public PuntajeModel(Integer valor, EstudianteModel estudiante, MateriaModel materia) {
        this.valor = valor;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public LocalDateTime getInsertFecha(){
        return insertFecha;
    }

    public void setInsertFecha(LocalDateTime insertFecha){
        this.insertFecha = insertFecha;
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
