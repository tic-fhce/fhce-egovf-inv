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
	private String _02codigo;
	
	@Column
	private String _03fechasolicitud;
	
	@Column
	private String _04horasolicitud;
	
	@Column
	private Long _05idtipo;
	
	@Column
	private Long _06idcaracteristica;
	
	@Column
	private String _07especificacion;
	
	@Column
	private String _08error;
	
	@Column
	private String _09detalle;
	
	@Column
	private String _10fechaatencion;
	
	@Column
	private String _11horaatencion;
	
	@Column
	private int _12estado;
	

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

	public String get_07especificacion() {
		return _07especificacion;
	}

	public void set_07especificacion(String _07especificacion) {
		this._07especificacion = _07especificacion;
	}

	public String get_08error() {
		return _08error;
	}

	public void set_08error(String _08error) {
		this._08error = _08error;
	}

	public String get_09detalle() {
		return _09detalle;
	}

	public void set_09detalle(String _09detalle) {
		this._09detalle = _09detalle;
	}

	public String get_10fechaatencion() {
		return _10fechaatencion;
	}

	public void set_10fechaatencion(String _10fechaatencion) {
		this._10fechaatencion = _10fechaatencion;
	}

	public String get_11horaatencion() {
		return _11horaatencion;
	}

	public void set_11horaatencion(String _11horaatencion) {
		this._11horaatencion = _11horaatencion;
	}

	public int get_12estado() {
		return _12estado;
	}

	public void set_12estado(int _12estado) {
		this._12estado = _12estado;
	}
	
	
}
