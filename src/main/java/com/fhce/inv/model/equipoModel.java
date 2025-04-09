package com.fhce.inv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name="equipo")
public class equipoModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    protected Long id;

    @Column(name = "_01codigo")
    protected String codigo;

    @Column(name = "_02macserie")
    protected String macSerie;

    @Column(name = "_03marca")
    protected String marca;

    @Column(name = "_04idtipo")
    protected Long idTipo;
    
    @Column(name = "_05modelo")
    protected String modelo;
    
    @Column(name = "_06detalle")
    protected String detalle;
}
