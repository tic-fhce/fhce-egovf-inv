package com.fhce.inv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="atencion")
public class atencionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true,nullable = false)
	private Long id;
	
	@Column(name = "_01idequipo")
    private Long idEquipo;

    @Column(name = "_02fechasolicitud")
    private String fechasolicitud;

    @Column(name = "_03horasolicitud")
    private String horasolicitud;

    @Column(name = "_04especificacion")
    private String especificacion;

    @Column(name = "_05error")
    private String error;

    @Column(name = "_06solucion")
    private String solucion;

    @Column(name = "_07fechaatencion")
    private String fechaatencion;

    @Column(name = "_08horaatencion")
    private String horaatencion;

    @Column(name = "_09estado")
    private int estado;
    
    @Column(name = "_10idpertenece")
    private Long idPertenece;
    
    @Column(name = "_11idtipo")
    private Long idTipo;

}
