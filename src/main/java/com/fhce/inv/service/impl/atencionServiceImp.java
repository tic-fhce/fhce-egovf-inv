package com.fhce.inv.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fhce.inv.dao.atencionDao;
import com.fhce.inv.dao.solicitudAtencionDao;
import com.fhce.inv.model.atencionModel;
import com.fhce.inv.model.solicitudAtencionModel;
import com.fhce.inv.obj.atencionRequestDTO;
import com.fhce.inv.obj.atencionResponseDTO;
import com.fhce.inv.service.atencionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class atencionServiceImp implements atencionService {

    private final atencionDao atencionDao;
    private final solicitudAtencionDao solicitudDao;

    @Override
    @Transactional
    public atencionResponseDTO crearAtencion(atencionRequestDTO request) {
        solicitudAtencionModel solicitud = solicitudDao.findById(request.getIdSolicitud())
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        
        if (solicitud.getEstado() == 1) {
            throw new RuntimeException("La solicitud ya ha sido atendida");
        }
        
        atencionModel atencion = new atencionModel();
        atencion.setSolicitud(solicitud);
        atencion.setSolucion(request.getSolucion());
        atencion.setFechaAtencion(request.getFechaAtencion() != null ? 
                                 request.getFechaAtencion() : LocalDate.now());
        atencion.setHoraAtencion(request.getHoraAtencion());
        atencion.setObservaciones(request.getObservaciones());
        
        atencionModel savedAtencion = atencionDao.save(atencion);
        
        // Marcar solicitud como atendida
        solicitud.setEstado(1);
        solicitudDao.save(solicitud);
        
        return convertAtencionToDTO(savedAtencion);
    }
    
    @Override
    @Transactional
    public atencionResponseDTO actualizarAtencion(Long idAtencion, atencionRequestDTO request) {
        atencionModel atencion = atencionDao.findById(idAtencion)
                .orElseThrow(() -> new RuntimeException("Atención no encontrada"));
        
        // Actualizar
        if (request.getSolucion() != null) {
            atencion.setSolucion(request.getSolucion());
        }
        if (request.getObservaciones() != null) {
            atencion.setObservaciones(request.getObservaciones());
        }
        if (request.getFechaAtencion() != null) {
            atencion.setFechaAtencion(request.getFechaAtencion());
        }
        if (request.getHoraAtencion() != null) {
            atencion.setHoraAtencion(request.getHoraAtencion());
        }
        
        atencionModel updated = atencionDao.save(atencion);
        
        return convertAtencionToDTO(updated);
    }
    
    @Override
    @Transactional(readOnly = true)
    public atencionResponseDTO getAtencion(Long idAtencion) {
        atencionModel atencion = atencionDao.findById(idAtencion)
                .orElseThrow(() -> new RuntimeException("Atención no encontrada"));
        
        return convertAtencionToDTO(atencion);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<atencionResponseDTO> getAtencionesPorSolicitud(Long idSolicitud) {
        List<atencionModel> atenciones = atencionDao.findBySolicitudIdSolicitudOrderByFechaAtencionDesc(idSolicitud);
        
        return atenciones.stream()
                .map(this::convertAtencionToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<atencionResponseDTO> getAtencionesPorEquipo(Long idEquipo) {
        List<atencionModel> atenciones = atencionDao.findByEquipoIdOrderByFechaDesc(idEquipo);
        
        return atenciones.stream()
                .map(this::convertAtencionToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<atencionResponseDTO> getTodasLasAtenciones() {
        List<atencionModel> atenciones = atencionDao.findAllByOrderByFechaAtencionDesc();
        
        return atenciones.stream()
                .map(this::convertAtencionToDTO)
                .collect(Collectors.toList());
    }
    
    private atencionResponseDTO convertAtencionToDTO(atencionModel atencion) {
        atencionResponseDTO dto = new atencionResponseDTO();
        dto.setIdAtencion(atencion.getIdAtencion());
        dto.setIdSolicitud(atencion.getSolicitud().getIdSolicitud());
        dto.setSolucion(atencion.getSolucion());
        dto.setFechaAtencion(atencion.getFechaAtencion());
        dto.setHoraAtencion(atencion.getHoraAtencion());
        dto.setObservaciones(atencion.getObservaciones());
        
        return dto;
    }
}