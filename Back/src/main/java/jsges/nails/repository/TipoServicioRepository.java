package jsges.nails.repository;

import jsges.nails.model.Linea;
import jsges.nails.model.TipoServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer> {

    @Query("select p from TipoServicio p  where p.estado=0 order by p.denominacion")
    List<TipoServicio> buscarNoEliminados();


    @Query("SELECT p FROM TipoServicio p WHERE p.estado = 0 AND  p.denominacion LIKE %:consulta% ORDER BY p.denominacion")
    List<TipoServicio> buscarNoEliminados(@Param("consulta") String consulta);

    @Query("SELECT p FROM TipoServicio p WHERE p.estado = 0 AND p.denominacion LIKE %:consulta% ORDER BY p.denominacion")
    Page<TipoServicio> buscarNoEliminadoss(@Param("consulta") String consulta, Pageable pageable);

}
