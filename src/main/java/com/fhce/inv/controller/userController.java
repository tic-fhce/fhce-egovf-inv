package com.fhce.inv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fhce.inv.obj.perteneceResponseDTO;
import com.fhce.inv.obj.solicitudAtencionCompletaDTO;
import com.fhce.inv.obj.solicitudAtencionRequestDTO;
import com.fhce.inv.obj.solicitudAtencionResponseDTO;
import com.fhce.inv.obj.atencionResponseDTO;
import com.fhce.inv.service.perteneceService;
import com.fhce.inv.service.solicitudService;
import com.fhce.inv.service.atencionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class userController {

    private final perteneceService perteneceService;
    private final solicitudService solicitudService;
    private final atencionService atencionService;
    
    //Obtener todos los equipos asignados a un usuario (por CIF)
    @GetMapping("/mis-equipos")
    public ResponseEntity<?> getMisEquipos(@RequestParam Long cif) {
        try {
            List<perteneceResponseDTO> response = perteneceService.getPerteneceByCif(cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener equipos del usuario");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    //Obtener historial completo de equipos de un usuario
    @GetMapping("/historial-equipos")
    public ResponseEntity<?> getHistorialEquipos(@RequestParam Long cif) {
        try {
            List<perteneceResponseDTO> response = perteneceService.getHistorialPorCif(cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener historial de equipos");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    //Crear solicitud de atención (solo para equipos asignados al usuario)
    @PostMapping("/crear-solicitud")
    public ResponseEntity<?> crearSolicitud(@RequestParam Long cif, @RequestBody solicitudAtencionRequestDTO request) {
        try {
            // Verifica que el equipo pertenece al usuario
            List<perteneceResponseDTO> equiposUsuario = perteneceService.getPertenecePorEquipoYCif(
                request.getIdEquipo(), cif);
            
            if (equiposUsuario.isEmpty()) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para crear solicitudes para este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            solicitudAtencionResponseDTO response = solicitudService.crearSolicitud(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al crear solicitud");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Obtener todas las solicitudes del usuario
    @GetMapping("/mis-solicitudes")
    public ResponseEntity<?> getMisSolicitudes(@RequestParam Long cif) {
        try {
            List<solicitudAtencionCompletaDTO> response = solicitudService.getSolicitudesPorCif(cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener solicitudes del usuario");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    //Obtener solicitudes pendientes del usuario
    @GetMapping("/solicitudes-pendientes")
    public ResponseEntity<?> getSolicitudesPendientes(@RequestParam Long cif) {
        try {
            List<solicitudAtencionCompletaDTO> todasSolicitudes = solicitudService.getSolicitudesPorCif(cif);
            List<solicitudAtencionCompletaDTO> pendientes = todasSolicitudes.stream()
                .filter(s -> s.getEstado() == 0)
                .toList();
            return new ResponseEntity<>(pendientes, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener solicitudes pendientes");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    

    //Obtener una solicitud específica (solo si pertenece al usuario)
    @GetMapping("/solicitud/porIdSolicitud")
    public ResponseEntity<?> getSolicitud(@RequestParam Long idSolicitud, @RequestParam Long cif) {
        try {
            solicitudAtencionCompletaDTO solicitud = solicitudService.getSolicitudCompleta(idSolicitud);
            
            //Verifica que la solicitud pertenece al usuario
            if (!solicitud.getCifSolicitante().equals(cif)) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver esta solicitud");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            return new ResponseEntity<>(solicitud, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Solicitud no encontrada");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
   
    //Actualizar solicitud (solo si está pendiente y pertenece al usuario)
    @PutMapping("/actualizar-solicitud")
    public ResponseEntity<?> actualizarSolicitud(@RequestParam Long idSolicitud, @RequestParam Long cif,
            @RequestBody solicitudAtencionRequestDTO request) {
        try {
            solicitudAtencionCompletaDTO solicitudExistente = solicitudService.getSolicitudCompleta(idSolicitud);
            
            if (!solicitudExistente.getCifSolicitante().equals(cif)) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para modificar esta solicitud");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            if (solicitudExistente.getEstado() != 0) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "Solo se pueden modificar solicitudes pendientes");
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
            
            solicitudAtencionResponseDTO response = solicitudService.actualizarSolicitud(idSolicitud, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al actualizar solicitud");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    
    
    //Obtener todas las atenciones de equipos del usuario
    @GetMapping("/mis-atenciones")
    public ResponseEntity<?> getMisAtenciones(@RequestParam Long cif) {
        try {
            List<atencionResponseDTO> response = atencionService.getAtencionesPorCif(cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener atenciones del usuario");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    //Obtener atenciones de un equipo específico (solo si pertenece al usuario)
    @GetMapping("/atenciones-equipo")
    public ResponseEntity<?> getAtencionesEquipo(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            List<perteneceResponseDTO> equiposUsuario = perteneceService.getPertenecePorEquipoYCif(idEquipo, cif);
            
            if (equiposUsuario.isEmpty()) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver las atenciones de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            List<atencionResponseDTO> response = atencionService.getAtencionesPorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener atenciones del equipo");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    //Obtener solicitudes de un equipo específico (solo si pertenece al usuario)
    @GetMapping("/solicitudes-equipo")
    public ResponseEntity<?> getSolicitudesEquipo(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            List<perteneceResponseDTO> equiposUsuario = perteneceService.getPertenecePorEquipoYCif(idEquipo, cif);
            
            if (equiposUsuario.isEmpty()) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver las solicitudes de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            List<solicitudAtencionCompletaDTO> response = solicitudService.getSolicitudesPorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener solicitudes del equipo");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    //Obtener historial de un equipo específico (solo si pertenece al usuario)
    @GetMapping("/historial-equipo")
    public ResponseEntity<?> getHistorialEquipo(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            // Verificar que el equipo pertenece o perteneció al usuario
            List<perteneceResponseDTO> historialEquipo = perteneceService.getHistorialPorEquipo(idEquipo);
            
            boolean tienePermiso = historialEquipo.stream()
                .anyMatch(p -> p.getCif().equals(cif));
            
            if (!tienePermiso) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver el historial de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            return new ResponseEntity<>(historialEquipo, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener historial del equipo");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}