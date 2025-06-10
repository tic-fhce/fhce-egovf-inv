package com.fhce.inv.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fhce.inv.dao.equipoDao;
import com.fhce.inv.dao.perteneceDao;
import com.fhce.inv.dao.solicitudAtencionDao;
import com.fhce.inv.model.atencionModel;
import com.fhce.inv.model.equipoModel;
import com.fhce.inv.model.perteneceModel;
import com.fhce.inv.model.solicitudAtencionModel;
import com.fhce.inv.obj.solicitudAtencionCompletaDTO;
import com.fhce.inv.obj.solicitudAtencionRequestDTO;
import com.fhce.inv.obj.solicitudAtencionResponseDTO;
import com.fhce.inv.service.solicitudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class solicitudServiceImp implements solicitudService {

    private final solicitudAtencionDao solicitudDao;
    private final equipoDao equipoDao;
    private final perteneceDao perteneceDao;
    
    @Override
    @Transactional
    public solicitudAtencionResponseDTO crearSolicitud(solicitudAtencionRequestDTO request) {
        equipoModel equipo = equipoDao.findById(request.getIdEquipo())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        
        LocalDate fechaSolicitud = request.getFechaSolicitud() != null ? 
                                  request.getFechaSolicitud() : LocalDate.now();
        perteneceModel responsableHistorico = perteneceDao.findResponsableEnFechaAdd(equipo, fechaSolicitud);
        
        if (responsableHistorico == null) {
            throw new RuntimeException("No se encontró responsable del equipo para la fecha de la solicitud");
        }

        solicitudAtencionModel solicitud = new solicitudAtencionModel();
        solicitud.setEquipo(equipo);
        solicitud.setFechaSolicitud(fechaSolicitud);
        solicitud.setHoraSolicitud(request.getHoraSolicitud());
        solicitud.setEspecificacion(request.getEspecificacion());
        solicitud.setError(request.getError());
        solicitud.setEstado(0); // En espera
        
        solicitudAtencionModel savedSolicitud = solicitudDao.save(solicitud);
        solicitudAtencionResponseDTO response = new solicitudAtencionResponseDTO();
        response.setIdSolicitud(savedSolicitud.getIdSolicitud());
        response.setIdEquipo(savedSolicitud.getEquipo().getIdequipo());
        response.setCodigoEquipo(savedSolicitud.getEquipo().getCodigo());
        response.setCifSolicitante(responsableHistorico.getCif());
        response.setFechaSolicitud(savedSolicitud.getFechaSolicitud());
        response.setHoraSolicitud(savedSolicitud.getHoraSolicitud());
        response.setEspecificacion(savedSolicitud.getEspecificacion());
        response.setError(savedSolicitud.getError());
        response.setEstado(savedSolicitud.getEstado());
        
        return response;
    }
    
    @Override
    @Transactional
    public solicitudAtencionResponseDTO actualizarSolicitud(Long idSolicitud, 
                                                           solicitudAtencionRequestDTO request) {
        solicitudAtencionModel solicitud = solicitudDao.findById(idSolicitud)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        
        if (solicitud.getEstado() == 1) {
            throw new RuntimeException("No se puede modificar una solicitud ya atendida");
        }
        
        if (request.getEspecificacion() != null) {
            solicitud.setEspecificacion(request.getEspecificacion());
        }
        if (request.getError() != null) {
            solicitud.setError(request.getError());
        }
        
        solicitudAtencionModel updated = solicitudDao.save(solicitud);
        List<perteneceModel> asignacionesActivas = perteneceDao.findByEquipoAndEstado(
            updated.getEquipo(), "ACTIVO");
        perteneceModel asignacionActiva = asignacionesActivas.isEmpty() ? null : asignacionesActivas.get(0);
        
        solicitudAtencionResponseDTO response = new solicitudAtencionResponseDTO();
        response.setIdSolicitud(updated.getIdSolicitud());
        response.setIdEquipo(updated.getEquipo().getIdequipo());
        response.setCodigoEquipo(updated.getEquipo().getCodigo());
        response.setCifSolicitante(asignacionActiva != null ? asignacionActiva.getCif() : null);
        response.setFechaSolicitud(updated.getFechaSolicitud());
        response.setHoraSolicitud(updated.getHoraSolicitud());
        response.setEspecificacion(updated.getEspecificacion());
        response.setError(updated.getError());
        response.setEstado(updated.getEstado());
        
        return response;
    }
    
    @Override
    @Transactional
    public solicitudAtencionCompletaDTO getSolicitudCompleta(Long idSolicitud) {
        solicitudAtencionModel solicitud = solicitudDao.findById(idSolicitud)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        
        return convertSolicitudCompleta(solicitud);
    }
    
    @Override
    @Transactional
    public List<solicitudAtencionCompletaDTO> getSolicitudesEnEspera() {
        List<solicitudAtencionModel> solicitudes = solicitudDao.findByEstadoOrderByFechaSolicitudAsc(0);
        return solicitudes.stream()
                .map(this::convertSolicitudCompleta)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional
    public List<solicitudAtencionCompletaDTO> getSolicitudesAtendidas() {
        List<solicitudAtencionModel> solicitudes = solicitudDao.findByEstado(1);
        return solicitudes.stream()
                .map(this::convertSolicitudCompleta)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional
    public List<solicitudAtencionCompletaDTO> getSolicitudesPorEquipo(Long idEquipo) {
        equipoModel equipo = equipoDao.findById(idEquipo)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        
        List<solicitudAtencionModel> solicitudes = solicitudDao.findByEquipoOrderByFechaSolicitudDesc(equipo);
        return solicitudes.stream()
                .map(this::convertSolicitudCompleta)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional
    public List<solicitudAtencionCompletaDTO> getSolicitudesPorCif(Long cif) {
        List<solicitudAtencionModel> solicitudes = solicitudDao.findByCifSolicitante(cif);
        return solicitudes.stream()
                .map(this::convertSolicitudCompleta)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<solicitudAtencionCompletaDTO> getTodasLasSolicitudes() {
        List<solicitudAtencionModel> solicitudes = solicitudDao.findAllByOrderByFechaSolicitudDesc();
        return solicitudes.stream()
                .map(this::convertSolicitudCompleta)
                .collect(Collectors.toList());
    }

    private solicitudAtencionCompletaDTO convertSolicitudCompleta(solicitudAtencionModel solicitud) {
        solicitudAtencionCompletaDTO dto = new solicitudAtencionCompletaDTO();
        
        dto.setIdSolicitud(solicitud.getIdSolicitud());
        dto.setIdEquipo(solicitud.getEquipo().getIdequipo());
        dto.setCodigoEquipo(solicitud.getEquipo().getCodigo());
        dto.setEquipoDescripcion(solicitud.getEquipo().getMarca() + " " + solicitud.getEquipo().getModelo());
        dto.setFechaSolicitud(solicitud.getFechaSolicitud());
        dto.setHoraSolicitud(solicitud.getHoraSolicitud());
        dto.setEspecificacion(solicitud.getEspecificacion());
        dto.setError(solicitud.getError());
        dto.setEstado(solicitud.getEstado());
        dto.setTipoEquipo(solicitud.getEquipo().getTipo().getNombre());
        
        try {
            perteneceModel responsableHistorico = perteneceDao.findResponsableEnFechaAdd(
                solicitud.getEquipo(), solicitud.getFechaSolicitud());
            
            if (responsableHistorico != null) {
                dto.setCifSolicitante(responsableHistorico.getCif());
            } else {
                List<perteneceModel> cualquierAsignacion = perteneceDao.findByEquipoOrderByFechaAddDesc(solicitud.getEquipo());
                if (!cualquierAsignacion.isEmpty()) {
                    dto.setCifSolicitante(cualquierAsignacion.get(0).getCif());
                }
            }
        } catch (Exception e) {
            System.out.println("Error buscando CIF histórico: " + e.getMessage());
            List<perteneceModel> asignacionesActivas = perteneceDao.findByEquipoAndEstado(
                solicitud.getEquipo(), "ACTIVO");
            if (!asignacionesActivas.isEmpty()) {
                dto.setCifSolicitante(asignacionesActivas.get(0).getCif());
            }
        }
        
        if (solicitud.getEstado() == 1 && solicitud.getAtenciones() != null && !solicitud.getAtenciones().isEmpty()) {
            atencionModel atencion = solicitud.getAtenciones().get(0);
            dto.setIdAtencion(atencion.getIdAtencion());
            dto.setSolucion(atencion.getSolucion());
            dto.setFechaAtencion(atencion.getFechaAtencion());
            dto.setHoraAtencion(atencion.getHoraAtencion());
            dto.setObservaciones(atencion.getObservaciones());
        }
        
        dto.setResumenDetallado(createSolicitudSummary(solicitud));
        
        return dto;
    }
    
    private List<String> createSolicitudSummary(solicitudAtencionModel solicitud) {
        List<String> resumen = new ArrayList<>();
        equipoModel equipo = solicitud.getEquipo();
        
        resumen.add("=== SOLICITUD ===");
        resumen.add("ID: " + solicitud.getIdSolicitud());
        resumen.add("Estado: " + (solicitud.getEstado() == 1 ? "Atendida" : "En espera"));
        resumen.add("Fecha: " + solicitud.getFechaSolicitud());
        
        resumen.add("=== EQUIPO ===");
        resumen.add("Código: " + equipo.getCodigo());
        resumen.add("Tipo: " + equipo.getTipo().getNombre());
        resumen.add("Marca/Modelo: " + equipo.getMarca() + " " + equipo.getModelo());
        
        resumen.add("=== PROBLEMA ===");
        resumen.add("Error: " + solicitud.getError());
        if (solicitud.getEspecificacion() != null && !solicitud.getEspecificacion().trim().isEmpty()) {
            resumen.add("Detalles: " + solicitud.getEspecificacion());
        }
        
        return resumen;
    }
}