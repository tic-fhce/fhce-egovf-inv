package com.fhce.egovf.obj;

import javax.persistence.Column;

public class pcObj {
	private Long idPc;
	private Long cif;
	private String codigo;
	private String fuente;
	private int memorias;
	private String capacidad;
	private String micro;
	private String micro_capacidad;
	private String sistema;
	private String disco;
	private String ip;
	private String mac;
	private String dns;
	private String segmento;
	private String cortapico;
	private String detalle;
	private String swit;
	private String puerto;
	private String vlan;
	private Long idubicacion;
	private Long idPertenece;
	private String fecha_add;
	private String fecha_del;
	private int estado;
	public pcObj(Long idPc, Long cif, String codigo, String fuente, int memorias, String capacidad, String micro,
			String micro_capacidad, String sistema, String disco, String ip, String mac, String dns, String segmento,
			String cortapico, String detalle, String swit, String puerto, String vlan, Long idubicacion,
			Long idPertenece, String fecha_add, String fecha_del, int estado) {
		super();
		this.idPc = idPc;
		this.cif = cif;
		this.codigo = codigo;
		this.fuente = fuente;
		this.memorias = memorias;
		this.capacidad = capacidad;
		this.micro = micro;
		this.micro_capacidad = micro_capacidad;
		this.sistema = sistema;
		this.disco = disco;
		this.ip = ip;
		this.mac = mac;
		this.dns = dns;
		this.segmento = segmento;
		this.cortapico = cortapico;
		this.detalle = detalle;
		this.swit = swit;
		this.puerto = puerto;
		this.vlan = vlan;
		this.idubicacion = idubicacion;
		this.idPertenece = idPertenece;
		this.fecha_add = fecha_add;
		this.fecha_del = fecha_del;
		this.estado = estado;
	}
	public Long getIdPc() {
		return idPc;
	}
	public void setIdPc(Long idPc) {
		this.idPc = idPc;
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
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	public int getMemorias() {
		return memorias;
	}
	public void setMemorias(int memorias) {
		this.memorias = memorias;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public String getMicro() {
		return micro;
	}
	public void setMicro(String micro) {
		this.micro = micro;
	}
	public String getMicro_capacidad() {
		return micro_capacidad;
	}
	public void setMicro_capacidad(String micro_capacidad) {
		this.micro_capacidad = micro_capacidad;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public String getCortapico() {
		return cortapico;
	}
	public void setCortapico(String cortapico) {
		this.cortapico = cortapico;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getSwit() {
		return swit;
	}
	public void setSwit(String swit) {
		this.swit = swit;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public String getVlan() {
		return vlan;
	}
	public void setVlan(String vlan) {
		this.vlan = vlan;
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
