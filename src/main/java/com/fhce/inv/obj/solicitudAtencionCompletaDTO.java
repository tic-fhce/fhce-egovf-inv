package com.fhce.inv.obj;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class solicitudAtencionCompletaDTO {
    // Datos de la solicitud
    private Long idSolicitud;
    private Long idEquipo;
    private String codigoEquipo;
    private String equipoDescripcion;
    private Long cifSolicitante;
    private LocalDate fechaSolicitud;
    private String horaSolicitud;
    private String especificacion;
    private String error;
    private int estado;
    
    // Datos de la atención (si existe)
    private Long idAtencion;
    private String solucion;
    private LocalDate fechaAtencion;
    private String horaAtencion;
    private String observaciones;
    
    // Información adicional del equipo
    private String tipoEquipo;
    private String ubicacionActual;
    private List<String> resumenDetallado;
}