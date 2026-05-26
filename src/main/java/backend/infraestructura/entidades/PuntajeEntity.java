package backend.infraestructura.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "puntajes")
public class PuntajeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor")
    private double valor;
    @ManyToOne @JoinColumn(name = "estudiante_id")
    private EstudianteEntity estudiante;
    @ManyToOne @JoinColumn(name = "materia_id")
    private MateriaEntity materia;
}