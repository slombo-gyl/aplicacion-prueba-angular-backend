package backend.infraestructura.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "materia")
public class MateriaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;
    private int puntaje;
    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;
}