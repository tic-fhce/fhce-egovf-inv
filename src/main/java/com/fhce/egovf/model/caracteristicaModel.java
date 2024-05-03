package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="caracteristica")
public class caracteristicaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	
	@Column
	private Long _01idtipo;
	
	@Column
	private String _02detalle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long get_01idtipo() {
		return _01idtipo;
	}

	public void set_01idtipo(Long _01idtipo) {
		this._01idtipo = _01idtipo;
	}

	public String get_02detalle() {
		return _02detalle;
	}

	public void set_02detalle(String _02detalle) {
		this._02detalle = _02detalle;
	}

}
