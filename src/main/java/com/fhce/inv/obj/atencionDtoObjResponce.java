package com.fhce.inv.obj;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class atencionDtoObjResponce {
	
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

}
