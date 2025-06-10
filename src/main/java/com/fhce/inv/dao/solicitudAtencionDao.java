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
    
    @Query("SELECT s FROM solicitudAtencionModel s " +
           "JOIN s.equipo e " +
           "JOIN e.asignaciones p " +
           "WHERE p.cif = :cif AND p.estado = 'ACTIVO' " +
           "ORDER BY s.fechaSolicitud DESC")
    List<solicitudAtencionModel> findByCifSolicitante(@Param("cif") Long cif);
}