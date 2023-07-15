package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="impresora")
public class impresoraModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private Long _01cif;
	
	/*Datos de Impresora*/
	@Column
	private String _02codigo;
	
	@Column
	private String _03marca;
	
	@Column
	private String _04modelo;
	
	@Column
	private String _05detalle;

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

	public String get_04modelo() {
		return _04modelo;
	}

	public void set_04modelo(String _04modelo) {
		this._04modelo = _04modelo;
	}

	public String get_05detalle() {
		return _05detalle;
	}

	public void set_05detalle(String _05detalle) {
		this._05detalle = _05detalle;
	}
	
}
