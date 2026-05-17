package backend.Infraestructura.output.persistencia.entity.puntaje;

import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.entity.materia.MateriaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "puntajes")
public class PuntajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DecimalMin(value = "0.0", message = "El puntaje no puede ser menor a 0")
    @DecimalMax(value = "10.0", message = "El puntaje no puede ser mayor a 10")
    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estudiante_id", nullable = false)
    private EstudianteEntity estudiante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "materia_id", nullable = false)
    private MateriaEntity materia;
}