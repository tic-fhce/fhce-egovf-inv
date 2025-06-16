package com.fhce.inv.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fhce.inv.model.equipoModel;
import com.fhce.inv.model.solicitudAtencionModel;

@Repository
public interface solicitudAtencionDao extends JpaRepository<solicitudAtencionModel, Long> {
	List<solicitudAtencionModel> findByEstadoOrderByFechaSolicitudAsc(int estado);
    List<solicitudAtencionModel> findByEstado(int estado);
    List<solicitudAtencionModel> findByEquipoOrderByFechaSolicitudDesc(equipoModel equipo);
    List<solicitudAtencionModel> findAllByOrderByFechaSolicitudDesc();
    
    /*@Query("SELECT s FROM solicitudAtencionModel s " +
           "JOIN s.equipo e " +
           "JOIN e.asignaciones p " +
           "WHERE p.cif = :cif AND p.estado = 'ACTIVO' " +
           "ORDER BY s.fechaSolicitud DESC")
    List<solicitudAtencionModel> findByCifSolicitante(@Param("cif") Long cif);*/
    
    @Query("SELECT s FROM solicitudAtencionModel s " +
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
            "ORDER BY s.fechaSolicitud DESC")
     List<solicitudAtencionModel> findByCifSolicitante(@Param("cif") Long cif);
}