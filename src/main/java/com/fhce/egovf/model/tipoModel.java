package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo")
public class tipoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column 
	private String _01sigla;
	
	@Column
	private String _02nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String get_01sigla() {
		return _01sigla;
	}

	public void set_01sigla(String _01sigla) {
		this._01sigla = _01sigla;
	}

	public String get_02nombre() {
		return _02nombre;
	}

	public void set_02nombre(String _02nombre) {
		this._02nombre = _02nombre;
	}
	
	
}
