package jsges.nails.repository;

import jsges.nails.DTO.LineaDTO;
import jsges.nails.model.ArticuloVenta;
import jsges.nails.model.Cliente;
import jsges.nails.model.Linea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineaRepository extends JpaRepository<Linea, Integer> {

    @Query("select p from Linea p where p.estado=0 order by p.denominacion")
    List<Linea> buscarNoEliminados();


    @Query("SELECT p FROM Linea p WHERE p.estado = 0 AND p.denominacion LIKE %:consulta% ORDER BY p.denominacion")
    Page<Linea> buscarNoEliminadoss(@Param("consulta") String consulta, Pageable pageable);

    @Query("SELECT p FROM Linea p WHERE p.estado = 0 AND  p.denominacion LIKE:consulta ORDER BY p.denominacion")
    List<Linea> buscarExacto(@Param("consulta") String consulta);

    List<Linea> findByDenominacionContaining(String consulta);
}
