package com.fhce.inv.obj;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class atencionRequestDTO {
	private Long idSolicitud;
    private String solucion;
    private LocalDate fechaAtencion;
    private String horaAtencion;
    private String observaciones;
}
