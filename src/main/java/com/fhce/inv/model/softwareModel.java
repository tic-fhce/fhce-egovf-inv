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
@Table(name = "software")
public class softwareModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column(name = "_01nombre")
    private String nombre;
	
	@Column(name = "_02version")
    private String version;
		
	@Column(name = "_03estado_licencia")
    private String estadoLicencia;
	
	@Column(name = "_04tipo")
    private String tipo;
	
	@Column(name = "_05idequipo")
    private Long idEquipo;

}
