package backend.Infraestructura.output.persistencia.entity.materia;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@NoArgsConstructor
@Data
@Table(name = "materia")
public class MateriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private boolean activo = true;

    @Column(name = "delete_fecha")
    private LocalDateTime deleteFecha;

    @Column(name = "insert_fecha")
    private LocalDateTime insertFecha;


}
