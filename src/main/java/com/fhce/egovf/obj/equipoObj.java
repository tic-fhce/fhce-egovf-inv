package com.fhce.egovf.obj;

import java.util.List;

public class equipoObj {
	private Long id;
	private Long cif;
	private String tipo;
	private Long idtipo;
	private String codigo;
	private List<String>resumen;
	public equipoObj(Long id, Long cif, String tipo, Long idtipo, String codigo, List<String> resumen) {
		this.id = id;
		this.cif = cif;
		this.tipo = tipo;
		this.idtipo = idtipo;
		this.codigo = codigo;
		this.resumen = resumen;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(Long idtipo) {
		this.idtipo = idtipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<String> getResumen() {
		return resumen;
	}
	public void setResumen(List<String> resumen) {
		this.resumen = resumen;
	}
}
