package com.fhce.inv.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "solicitud_atencion")
public class solicitudAtencionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long idSolicitud;
    
    @ManyToOne
    @JoinColumn(name = "_01idequipo", nullable = false)
    private equipoModel equipo;
    
    @Column(name = "_02fechasolicitud", nullable = false)
    private LocalDate fechaSolicitud;
    
    @Column(name = "_03horasolicitud")
    private String horaSolicitud;
    
    @Column(name = "_04especificacion")
    private String especificacion;
    
    @Column(name = "_05error", nullable = false)
    private String error;
    
    @Column(name = "_06estado", nullable = false)
    private int estado = 0; // 0 = en espera, 1 = atendido
    
    // Relación uno a muchos con atenciones (una solicitud puede tener múltiples intentos de atención)
    @OneToMany(mappedBy = "solicitud")
    private List<atencionModel> atenciones;
}