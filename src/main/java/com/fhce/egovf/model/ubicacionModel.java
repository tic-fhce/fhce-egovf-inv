package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ubicacion")
public class ubicacionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private Long _01cif;
	
	@Column
	private String _02ambiente;
	
	@Column
	private String _03ubicacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long get_01cif() {
		return _01cif;
	}

	public void set_01cif(Long _01cif) {
		this._01cif = _01cif;
	}

	public String get_02ambiente() {
		return _02ambiente;
	}

	public void set_02ambiente(String _02ambiente) {
		this._02ambiente = _02ambiente;
	}

	public String get_03ubicacion() {
		return _03ubicacion;
	}

	public void set_03ubicacion(String _03ubicacion) {
		this._03ubicacion = _03ubicacion;
	}
	
}
