package backend.Infraestructura.output.persistencia.adapater.studentAdapter;

import backend.Aplicacion.mapper.estudianteMapper.StudentMapper;
import backend.Dominio.modelo.EstudianteModel;
import backend.Dominio.puertos.out.estudiante.EstudianteRepositoryPort;
import backend.Infraestructura.output.persistencia.entity.estudiante.StudentEntity;
import backend.Infraestructura.output.persistencia.repository.estudiante.StudentJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class EstudianteRepositoryAdapter implements EstudianteRepositoryPort {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public EstudianteModel guardar(EstudianteModel student) {
        StudentEntity entity = StudentMapper.toEntity(student);
        StudentEntity saved = studentJpaRepository.save(entity);
        return StudentMapper.toModel(saved);
    }


}
