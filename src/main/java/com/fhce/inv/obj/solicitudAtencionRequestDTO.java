package com.fhce.inv.obj;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class solicitudAtencionRequestDTO {
    private Long idEquipo;
    private LocalDate fechaSolicitud;
    private String horaSolicitud;
    private String especificacion;
    private String error;
}