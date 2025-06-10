package com.fhce.inv.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "atencion")
public class atencionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long idAtencion;
    
    @ManyToOne
    @JoinColumn(name = "_01idsolicitud", nullable = false)
    private solicitudAtencionModel solicitud;
    
    @Column(name = "_02solucion")
    private String solucion;
    
    @Column(name = "_03fechaatencion", nullable = false)
    private LocalDate fechaAtencion;
    
    @Column(name = "_04horaatencion")
    private String horaAtencion;
    
    @Column(name = "_05observaciones")
    private String observaciones; // Para notas adicionales del técnico
}