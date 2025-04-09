package com.fhce.inv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="pertenece")
public class perteneceModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column(name = "_01cif")
	private Long cif;
	
	@Column(name = "_02idequipo")
	private Long idEquipo;
	
	@Column(name = "_03fechaadd")
	private String fechaAdd;
	
	@Column(name = "_04fechadel")
	private String fechaDel;
	
	@Column(name = "_05estado")
	private String estado;
}
