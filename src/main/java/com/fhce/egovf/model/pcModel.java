package com.fhce.egovf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pc")
public class pcModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column
	private Long _01cif;
	
	/*Datos de la PC*/
	@Column
	private String _02codigo;
	
	@Column
	private String _03fuente;
	
	@Column
	private int _04memorias;
	
	@Column
	private String _05capacidad;
	
	@Column
	private String _06micro;
	
	@Column
	private String _07micro_capacidad;
	
	@Column
	private String _08sistema;
	
	@Column
	private String _09disco;
	
	@Column
	private String _10ip;
	
	@Column
	private String _11mac;
	
	@Column
	private String _12dns;
	
	@Column
	private String _13segmento;

	@Column
	private String _14cortapico;
	
	@Column
	private String _15detalle;
	
	@Column
	private String _16switch;
	
	@Column
	private String _17puerto;
	
	@Column
	private String _18vlan;
	
	@Column
	private Long _19idubicacion;

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

	public String get_03fuente() {
		return _03fuente;
	}

	public void set_03fuente(String _03fuente) {
		this._03fuente = _03fuente;
	}

	public int get_04memorias() {
		return _04memorias;
	}

	public void set_04memorias(int _04memorias) {
		this._04memorias = _04memorias;
	}

	public String get_05capacidad() {
		return _05capacidad;
	}

	public void set_05capacidad(String _05capacidad) {
		this._05capacidad = _05capacidad;
	}

	public String get_06micro() {
		return _06micro;
	}

	public void set_06micro(String _06micro) {
		this._06micro = _06micro;
	}

	public String get_07micro_capacidad() {
		return _07micro_capacidad;
	}

	public void set_07micro_capacidad(String _07micro_capacidad) {
		this._07micro_capacidad = _07micro_capacidad;
	}

	public String get_08sistema() {
		return _08sistema;
	}

	public void set_08sistema(String _08sistema) {
		this._08sistema = _08sistema;
	}

	public String get_09disco() {
		return _09disco;
	}

	public void set_09disco(String _09disco) {
		this._09disco = _09disco;
	}

	public String get_10ip() {
		return _10ip;
	}

	public void set_10ip(String _10ip) {
		this._10ip = _10ip;
	}

	public String get_11mac() {
		return _11mac;
	}

	public void set_11mac(String _11mac) {
		this._11mac = _11mac;
	}

	public String get_12dns() {
		return _12dns;
	}

	public void set_12dns(String _12dns) {
		this._12dns = _12dns;
	}

	public String get_13segmento() {
		return _13segmento;
	}

	public void set_13segmento(String _13segmento) {
		this._13segmento = _13segmento;
	}

	public String get_14cortapico() {
		return _14cortapico;
	}

	public void set_14cortapico(String _14cortapico) {
		this._14cortapico = _14cortapico;
	}

	public String get_15detalle() {
		return _15detalle;
	}

	public void set_15detalle(String _15detalle) {
		this._15detalle = _15detalle;
	}

	public String get_16switch() {
		return _16switch;
	}

	public void set_16switch(String _16switch) {
		this._16switch = _16switch;
	}

	public String get_17puerto() {
		return _17puerto;
	}

	public void set_17puerto(String _17puerto) {
		this._17puerto = _17puerto;
	}

	public String get_18vlan() {
		return _18vlan;
	}

	public void set_18vlan(String _18vlan) {
		this._18vlan = _18vlan;
	}

	public Long get_19idubicacion() {
		return _19idubicacion;
	}

	public void set_19idubicacion(Long _19idubicacion) {
		this._19idubicacion = _19idubicacion;
	}
	
}
