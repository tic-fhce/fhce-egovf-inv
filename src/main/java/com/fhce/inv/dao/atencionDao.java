package com.fhce.inv.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fhce.inv.model.atencionModel;
@Repository
public interface atencionDao extends JpaRepository<atencionModel, Long> {
    
    
    List<atencionModel> findBySolicitudIdSolicitudOrderByFechaAtencionDesc(Long idSolicitud);
    
    @Query("SELECT a FROM atencionModel a " +
           "JOIN a.solicitud s " +
           "WHERE s.equipo.idequipo = :idEquipo " +
           "ORDER BY a.fechaAtencion DESC")
    List<atencionModel> findByEquipoIdOrderByFechaDesc(@Param("idEquipo") Long idEquipo);
    
    /*@Query("SELECT a FROM atencionModel a " +
           "JOIN a.solicitud s " +
           "JOIN s.equipo e " +
           "JOIN e.asignaciones p " +
           "WHERE p.cif = :cif AND p.estado = 'ACTIVO' " +
           "ORDER BY a.fechaAtencion DESC")*/

    List<atencionModel> findAllByOrderByFechaAtencionDesc();
    
    @Query("SELECT a FROM atencionModel a " +
            "JOIN a.solicitud s " +
            "WHERE s.equipo.idequipo IN (" +
            "  SELECT p1.equipo.idequipo FROM perteneceModel p1 " +
            "  WHERE p1.cif = :cif " +
            "  AND p1.fechaAdd <= s.fechaSolicitud " +
            "  AND p1.fechaAdd = (" +
            "    SELECT MAX(p2.fechaAdd) FROM perteneceModel p2 " +
            "    WHERE p2.equipo = p1.equipo " +
            "    AND p2.fechaAdd <= s.fechaSolicitud" +
            "  )" +
            ") " +
            "ORDER BY a.fechaAtencion DESC")
     List<atencionModel> findByCifHistorico(@Param("cif") Long cif);
}