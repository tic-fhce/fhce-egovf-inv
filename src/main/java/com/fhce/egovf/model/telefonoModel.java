package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="telefono")
public class telefonoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private Long _01cif;
	
	/*Datos del telefono*/
	@Column
	private String _02codigo;
	
	@Column
	private String _03marca;
	
	@Column
	private String _04ip;
	
	@Column
	private String _05interno;

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

	public String get_02codigo() {
		return _02codigo;
	}

	public void set_02codigo(String _02codigo) {
		this._02codigo = _02codigo;
	}

	public String get_03marca() {
		return _03marca;
	}

	public void set_03marca(String _03marca) {
		this._03marca = _03marca;
	}

	public String get_04ip() {
		return _04ip;
	}

	public void set_04ip(String _04ip) {
		this._04ip = _04ip;
	}

	public String get_05interno() {
		return _05interno;
	}

	public void set_05interno(String _05interno) {
		this._05interno = _05interno;
	}
	
}
