package backend.infraestructura.entities;

import backend.dominio.modelo.enums.Estado;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "materia")
public class MateriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Min(value = 0, message = "El puntaje no puede ser menor a 0")
    @Max(value = 10, message = "El puntaje no puede ser mayor a 10")
    @Column(nullable = false)
    private int puntaje;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.ACTIVO;
}