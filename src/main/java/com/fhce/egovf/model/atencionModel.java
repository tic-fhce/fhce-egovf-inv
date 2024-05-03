package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="atencion")
public class atencionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private Long _01cif;
	
	@Column
	private Long _02codigo;
	
	@Column
	private String _03fechasolicitud;
	
	@Column
	private String _04horasolicitud;
	
	@Column
	private Long _05idtipo;
	
	@Column
	private Long _06idcaracteristica;
	
	@Column
	private String _07error;
	
	@Column
	private String _08detalle;
	
	@Column
	private String _09fechaatencion;
	
	@Column
	private String _10horaatencion;

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

	public Long get_02codigo() {
		return _02codigo;
	}

	public void set_02codigo(Long _02codigo) {
		this._02codigo = _02codigo;
	}

	public String get_03fechasolicitud() {
		return _03fechasolicitud;
	}

	public void set_03fechasolicitud(String _03fechasolicitud) {
		this._03fechasolicitud = _03fechasolicitud;
	}

	public String get_04horasolicitud() {
		return _04horasolicitud;
	}

	public void set_04horasolicitud(String _04horasolicitud) {
		this._04horasolicitud = _04horasolicitud;
	}

	public Long get_05idtipo() {
		return _05idtipo;
	}

	public void set_05idtipo(Long _05idtipo) {
		this._05idtipo = _05idtipo;
	}

	public Long get_06idcaracteristica() {
		return _06idcaracteristica;
	}

	public void set_06idcaracteristica(Long _06idcaracteristica) {
		this._06idcaracteristica = _06idcaracteristica;
	}

	public String get_07error() {
		return _07error;
	}

	public void set_07error(String _07error) {
		this._07error = _07error;
	}

	public String get_08detalle() {
		return _08detalle;
	}

	public void set_08detalle(String _08detalle) {
		this._08detalle = _08detalle;
	}

	public String get_09fechaatencion() {
		return _09fechaatencion;
	}

	public void set_09fechaatencion(String _09fechaatencion) {
		this._09fechaatencion = _09fechaatencion;
	}

	public String get_10horaatencion() {
		return _10horaatencion;
	}

	public void set_10horaatencion(String _10horaatencion) {
		this._10horaatencion = _10horaatencion;
	}

}
