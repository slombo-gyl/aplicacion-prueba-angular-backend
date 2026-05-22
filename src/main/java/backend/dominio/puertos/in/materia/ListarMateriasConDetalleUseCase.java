package backend.dominio.puertos.in.materia;

import backend.aplicacion.dto.materia.MateriaDetalleResponseDTO;

import java.util.List;

public interface ListarMateriasConDetalleUseCase {
    List<MateriaDetalleResponseDTO> listarMateriasConDetalle();
}
