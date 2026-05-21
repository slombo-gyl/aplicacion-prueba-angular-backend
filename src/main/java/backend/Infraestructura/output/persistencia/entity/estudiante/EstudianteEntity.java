package backend.Infraestructura.output.persistencia.entity.estudiante;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;


    @Column(name="apellido")
    private String apellido;


    @Column(name = "dni")
    private int dni;


    @Column(name = "email")
    private String email;

    @Column(name = "INSERT_FECHA")
    private LocalDateTime insertFecha;

    @Column(name = "DELETE_FECHA")
    private LocalDateTime deleteFecha;
}