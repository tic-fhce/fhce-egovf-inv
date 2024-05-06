package com.fhce.egovf.obj;

import java.util.List;

public class atencionObj {
	
	private Long id;
	private Long cif;
	private String codigo;
	private String fechasolicitud;
	private String horasolicitud;
	private String equipo;
	private Long idtipo;
	private Long idcaracteristica;
	private List<String> resumen;
	private String caracteristica;
	private String especificacion;
	private String error;
	private String detalle;
	private String fechaatencion;
	private String horaatencion;
	private int estado;
	public atencionObj(Long id, Long cif, String codigo, String fechasolicitud, String horasolicitud, String equipo,
			List<String> resumen, String caracteristica, String especificacion, String error, String detalle,
			String fechaatencion, String horaatencion, int estado, Long idtipo,Long idcaracteristica) {
		this.id = id;
		this.cif = cif;
		this.codigo = codigo;
		this.fechasolicitud = fechasolicitud;
		this.horasolicitud = horasolicitud;
		this.equipo = equipo;
		this.resumen = resumen;
		this.caracteristica = caracteristica;
		this.especificacion = especificacion;
		this.error = error;
		this.detalle = detalle;
		this.fechaatencion = fechaatencion;
		this.horaatencion = horaatencion;
		this.estado = estado;
		this.idtipo = idtipo;
		this.idcaracteristica = idcaracteristica;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFechasolicitud() {
		return fechasolicitud;
	}
	public void setFechasolicitud(String fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}
	public String getHorasolicitud() {
		return horasolicitud;
	}
	public void setHorasolicitud(String horasolicitud) {
		this.horasolicitud = horasolicitud;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public List<String> getResumen() {
		return resumen;
	}
	public void setResumen(List<String> resumen) {
		this.resumen = resumen;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	public String getEspecificacion() {
		return especificacion;
	}
	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getFechaatencion() {
		return fechaatencion;
	}
	public void setFechaatencion(String fechaatencion) {
		this.fechaatencion = fechaatencion;
	}
	public String getHoraatencion() {
		return horaatencion;
	}
	public void setHoraatencion(String horaatencion) {
		this.horaatencion = horaatencion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Long getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(Long idtipo) {
		this.idtipo = idtipo;
	}
	public Long getIdcaracteristica() {
		return idcaracteristica;
	}
	public void setIdcaracteristica(Long idcaracteristica) {
		this.idcaracteristica = idcaracteristica;
	}
}
