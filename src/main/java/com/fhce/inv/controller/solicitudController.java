package com.fhce.inv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fhce.inv.obj.solicitudAtencionCompletaDTO;
import com.fhce.inv.obj.solicitudAtencionRequestDTO;
import com.fhce.inv.obj.solicitudAtencionResponseDTO;
import com.fhce.inv.service.solicitudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/solicitud")
@RequiredArgsConstructor
public class solicitudController {

    private final solicitudService solicitudService;
    
    @PostMapping("/add")
    public ResponseEntity<?> crearSolicitud(@RequestBody solicitudAtencionRequestDTO request) {
        try {
            solicitudAtencionResponseDTO response = solicitudService.crearSolicitud(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al crear solicitud");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> actualizarSolicitud(
            @RequestParam Long idSolicitud,
            @RequestBody solicitudAtencionRequestDTO request) {
        try {
            solicitudAtencionResponseDTO response = solicitudService.actualizarSolicitud(idSolicitud, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al actualizar solicitud");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/get")
    public ResponseEntity<?> getSolicitudCompleta(@RequestParam Long idSolicitud) {
        try {
            solicitudAtencionCompletaDTO response = solicitudService.getSolicitudCompleta(idSolicitud);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Solicitud no encontrada");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/lista-espera")
    public ResponseEntity<?> getSolicitudesPendientes() {
        try {
            List<solicitudAtencionCompletaDTO> response = solicitudService.getSolicitudesEnEspera();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener solicitudes pendientes");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/lista-atendidas")
    public ResponseEntity<?> getSolicitudesAtendidas() {
        try {
            List<solicitudAtencionCompletaDTO> response = solicitudService.getSolicitudesAtendidas();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener solicitudes atendidas");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porEquipo")
    public ResponseEntity<?> getSolicitudesPorEquipo(@RequestParam Long idEquipo) {
        try {
            List<solicitudAtencionCompletaDTO> response = solicitudService.getSolicitudesPorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener solicitudes del equipo");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/porCif")
    public ResponseEntity<?> getSolicitudesPorCif(@RequestParam Long cif) {
        try {
            List<solicitudAtencionCompletaDTO> response = solicitudService.getSolicitudesPorCif(cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener solicitudes del CIF");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/todas")
    public ResponseEntity<?> getTodasLasSolicitudes() {
        try {
            List<solicitudAtencionCompletaDTO> response = solicitudService.getTodasLasSolicitudes();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener todas las solicitudes");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
