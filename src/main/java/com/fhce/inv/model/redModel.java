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
@Table(name = "red")
public class redModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column(name = "_01ip")
	private String ip;
	
	@Column(name = "_02segmento")
	private String segmento;
	
	@Column(name = "_03dns")
	private String dns;
	
	@Column(name = "_04vlan")
	private String vlan;
	
	@Column(name = "_05switch")
	private String switchRed;
	
	@Column(name = "_06puerto")
	private String puerto;

	@Column(name = "_07fecharegistro")
	private String fechaRegistro;
	
	@Column(name = "_08idequipo")
	private Long idEquipo;

}
