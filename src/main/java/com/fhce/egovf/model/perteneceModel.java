package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pertenece")
public class perteneceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private Long _01cif;
	
	@Column
	private String _02codigo;
	
	@Column
	private String _03fecha_add;
	
	@Column
	private String _04fecha_del;
	
	@Column
	private int _05estado;
	
	@Column Long _06idtipo;

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

	public String get_03fecha_add() {
		return _03fecha_add;
	}

	public void set_03fecha_add(String _03fecha_add) {
		this._03fecha_add = _03fecha_add;
	}

	public String get_04fecha_del() {
		return _04fecha_del;
	}

	public void set_04fecha_del(String _04fecha_del) {
		this._04fecha_del = _04fecha_del;
	}

	public int get_05estado() {
		return _05estado;
	}

	public void set_05estado(int _05estado) {
		this._05estado = _05estado;
	}

	public Long get_06idtipo() {
		return _06idtipo;
	}

	public void set_06idtipo(Long _06idtipo) {
		this._06idtipo = _06idtipo;
	}
	
	
}
