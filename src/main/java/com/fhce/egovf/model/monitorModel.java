package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monitor")
public class monitorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private Long _01cif;
	
	/*Datos del Monitor*/
	
	@Column
	private String _02codigo;
	
	@Column
	private String _03marca;
	
	@Column
	private String _04pulgadas;
	
	@Column
	private String _05tipo;
	
	@Column
	private Long _06idubicacion;
	

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

	public String get_04pulgadas() {
		return _04pulgadas;
	}

	public void set_04pulgadas(String _04pulgadas) {
		this._04pulgadas = _04pulgadas;
	}

	public String get_05tipo() {
		return _05tipo;
	}

	public void set_05tipo(String _05tipo) {
		this._05tipo = _05tipo;
	}

	public Long get_06idubicacion() {
		return _06idubicacion;
	}

	public void set_06idubicacion(Long _06idubicacion) {
		this._06idubicacion = _06idubicacion;
	}
	
	
}
