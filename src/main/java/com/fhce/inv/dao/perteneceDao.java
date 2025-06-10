package com.fhce.inv.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fhce.inv.model.equipoModel;
import com.fhce.inv.model.perteneceModel;

public interface perteneceDao extends JpaRepository<perteneceModel, Long> {
    List<perteneceModel> findByCif(Long cif);
    List<perteneceModel> findByEquipo(equipoModel equipo);
    //List<perteneceModel> findByEquipoAndEstado(equipoModel equipo, String estado);
    
    List<perteneceModel> findByEquipoIdequipoAndCif(Long idEquipo, Long cif);
    
 // CAMBIADO: devuelve List en lugar de Optional
    @Query("SELECT p FROM perteneceModel p WHERE p.equipo = :equipo AND p.estado = :estado")
    List<perteneceModel> findByEquipoAndEstado(@Param("equipo") equipoModel equipo, @Param("estado") String estado);
    
    // Método alternativo con ID - también devuelve List
    List<perteneceModel> findByEquipoIdequipoAndEstado(Long idEquipo, String estado);
    
    // Historial de asignaciones por equipo
    List<perteneceModel> findByEquipoOrderByFechaAddDesc(equipoModel equipo);
    
    // Asignaciones por CIF
    List<perteneceModel> findByCifAndEstado(Long cif, String estado);
    
    List<perteneceModel> findByCifOrderByFechaAddDesc(Long cif);
    
    @Query("SELECT p FROM perteneceModel p WHERE p.equipo = :equipo " +
    	       "AND p.fechaAdd <= :fecha " +
    	       "ORDER BY p.fechaAdd DESC LIMIT 1")
    	perteneceModel findResponsableEnFechaAdd(@Param("equipo") equipoModel equipo, 
    	                                        @Param("fecha") LocalDate fecha);
}