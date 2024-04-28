package com.fhce.egovf.obj;

public class impresoraObj {
	private Long idImpresora;
	private Long cif;
	private String codigo;
	private String marca;
	private String modelo;
	private String detalle;
	private Long idubicacion;
	private Long idPertenece;
	private String fecha_add;
	private String fecha_del;
	private int estado;
	public impresoraObj(Long idImpresora, Long cif, String codigo, String marca, String modelo, String detalle,
			Long idubicacion, Long idPertenece, String fecha_add, String fecha_del, int estado) {
		this.idImpresora = idImpresora;
		this.cif = cif;
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.detalle = detalle;
		this.idubicacion = idubicacion;
		this.idPertenece = idPertenece;
		this.fecha_add = fecha_add;
		this.fecha_del = fecha_del;
		this.estado = estado;
	}
	public Long getIdImpresora() {
		return idImpresora;
	}
	public void setIdImpresora(Long idImpresora) {
		this.idImpresora = idImpresora;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
