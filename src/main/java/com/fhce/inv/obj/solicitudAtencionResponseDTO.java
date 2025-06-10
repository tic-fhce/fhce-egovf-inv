package com.fhce.inv.obj;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class solicitudAtencionResponseDTO {
    private Long idSolicitud;
    private Long idEquipo;
    private String codigoEquipo;
    private Long cifSolicitante; // Obtenido automáticamente del equipo
    private LocalDate fechaSolicitud;
    private String horaSolicitud;
    private String especificacion;
    private String error;
    private int estado;
}
