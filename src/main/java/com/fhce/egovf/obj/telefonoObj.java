package com.fhce.egovf.obj;

import javax.persistence.Column;

public class telefonoObj {
	
	private Long idTelefono;
	private Long cif;
	private String codigo;
	private String marca;
	private String ip;
	private String interno;
	private Long idubicacion;
	private Long idPertenece;
	private String fecha_add;
	private String fecha_del;
	private int estado;
	public telefonoObj(Long idTelefono, Long cif, String codigo, String marca, String ip, String interno,
			Long idubicacion, Long idPertenece, String fecha_add, String fecha_del, int estado) {
		this.idTelefono = idTelefono;
		this.cif = cif;
		this.codigo = codigo;
		this.marca = marca;
		this.ip = ip;
		this.interno = interno;
		this.idubicacion = idubicacion;
		this.idPertenece = idPertenece;
		this.fecha_add = fecha_add;
		this.fecha_del = fecha_del;
		this.estado = estado;
	}
	public Long getIdTelefono() {
		return idTelefono;
	}
	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}
	public Long getCif() {
		return cif;
	}
	public void setCif(Long cif) {
		this.cif = cif;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getInterno() {
		return interno;
	}
	public void setInterno(String interno) {
		this.interno = interno;
	}
	public Long getIdubicacion() {
		return idubicacion;
	}
	public void setIdubicacion(Long idubicacion) {
		this.idubicacion = idubicacion;
	}
	public Long getIdPertenece() {
		return idPertenece;
	}
	public void setIdPertenece(Long idPertenece) {
		this.idPertenece = idPertenece;
	}
	public String getFecha_add() {
		return fecha_add;
	}
	public void setFecha_add(String fecha_add) {
		this.fecha_add = fecha_add;
	}
	public String getFecha_del() {
		return fecha_del;
	}
	public void setFecha_del(String fecha_del) {
		this.fecha_del = fecha_del;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	

}
