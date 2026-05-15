package backend.Infraestructura.output.persistencia.entity.estudiante;

import backend.Dominio.modelo.enums.Estado;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "students")
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 25)
    @Column(name="nombre")
    private String nombre;

    @NotNull
    @Column(name="apellido")
    private String apellido;

    @NotNull
    @Column(name = "dni")
    private String dni;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado = Estado.ACTIVO;
}