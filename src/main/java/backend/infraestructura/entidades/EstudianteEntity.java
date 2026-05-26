package backend.infraestructura.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "students")
public class EstudianteEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Size(max = 25) @Column(name="nombre")
    private String nombre;
    @NotNull @Column(name="apellido")
    private String apellido;
    @NotNull @Digits(integer = 8,fraction = 0) @Column(name = "dni")
    private int dni;
    @NotNull @Email @Column(name = "email")
    private String email;
    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;
}