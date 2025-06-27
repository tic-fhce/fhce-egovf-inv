package com.fhce.inv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fhce.inv.obj.perteneceResponseDTO;
import com.fhce.inv.obj.redResponseDTO;
import com.fhce.inv.obj.softwareResponseDTO;
import com.fhce.inv.obj.ubicacionResponseDTO;
import com.fhce.inv.service.perteneceService;
import com.fhce.inv.service.redService;
import com.fhce.inv.service.softwareService;
import com.fhce.inv.service.ubicacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user/equipment")
@RequiredArgsConstructor
public class userEquipoController {

    private final perteneceService perteneceService;
    private final redService redService;
    private final softwareService softwareService;
    private final ubicacionService ubicacionService;
    
    private boolean verificarPropiedadEquipo(Long idEquipo, Long cif) {
        try {
            List<perteneceResponseDTO> equiposUsuario = perteneceService.getPertenecePorEquipoYCif(idEquipo, cif);
            return !equiposUsuario.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    
    //Obtener configuración de red activa de un equipo del usuario
    @GetMapping("/red-activa")
    public ResponseEntity<?> getRedActiva(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            if (!verificarPropiedadEquipo(idEquipo, cif)) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver la configuración de red de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            redResponseDTO response = redService.getRedActiva(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener configuración de red");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    //Obtener historial de configuraciones de red de un equipo del usuario
    @GetMapping("/historial-red")
    public ResponseEntity<?> getHistorialRed(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            if (!verificarPropiedadEquipo(idEquipo, cif)) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver el historial de red de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            List<redResponseDTO> response = redService.getHistorialRedes(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener historial de configuraciones de red");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //Obtener software instalado en un equipo del usuario
    @GetMapping("/software")
    public ResponseEntity<?> getSoftwareEquipo(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            if (!verificarPropiedadEquipo(idEquipo, cif)) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver el software de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            List<softwareResponseDTO> response = softwareService.getSoftwarePorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener software del equipo");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //Obtener ubicación actual de un equipo del usuario
    @GetMapping("/ubicacion-actual")
    public ResponseEntity<?> getUbicacionActual(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            if (!verificarPropiedadEquipo(idEquipo, cif)) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver la ubicación de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            ubicacionResponseDTO response = ubicacionService.getUbicacionActiva(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener ubicación actual");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    //Obtener historial de ubicaciones de un equipo del usuario
    @GetMapping("/historial-ubicaciones")
    public ResponseEntity<?> getHistorialUbicaciones(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            if (!verificarPropiedadEquipo(idEquipo, cif)) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver el historial de ubicaciones de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            List<ubicacionResponseDTO> response = ubicacionService.getHistorialUbicaciones(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener historial de ubicaciones");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //Obtener información completa de un equipo del usuario
    @GetMapping("/detalle-completo")
    public ResponseEntity<?> getDetalleCompletoEquipo(@RequestParam Long idEquipo, @RequestParam Long cif) {
        try {
            if (!verificarPropiedadEquipo(idEquipo, cif)) {
                Map<String, String> error = new HashMap<>();
                error.put("mensaje", "No tienes permisos para ver los detalles de este equipo");
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
            }
            
            Map<String, Object> detalleCompleto = new HashMap<>();
            
            //Información básica del equipo (asignación actual)
            List<perteneceResponseDTO> asignacion = perteneceService.getPertenecePorEquipoYCif(idEquipo, cif);
            detalleCompleto.put("asignacion", asignacion.isEmpty() ? null : asignacion.get(0));
            
            try {
                redResponseDTO redActiva = redService.getRedActiva(idEquipo);
                detalleCompleto.put("red_activa", redActiva);
            } catch (Exception e) {
                detalleCompleto.put("red_activa", null);
            }
            
            try {
                List<softwareResponseDTO> software = softwareService.getSoftwarePorEquipo(idEquipo);
                detalleCompleto.put("software", software);
            } catch (Exception e) {
                detalleCompleto.put("software", List.of());
            }
            
            try {
                ubicacionResponseDTO ubicacion = ubicacionService.getUbicacionActiva(idEquipo);
                detalleCompleto.put("ubicacion_actual", ubicacion);
            } catch (Exception e) {
                detalleCompleto.put("ubicacion_actual", null);
            }
            
            return new ResponseEntity<>(detalleCompleto, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener detalles del equipo");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //Verificar estado de conectividad de equipos del usuario
    @GetMapping("/estado-conectividad")
    public ResponseEntity<?> getEstadoConectividad(@RequestParam Long cif) {
        try {
            List<perteneceResponseDTO> equipos = perteneceService.getPerteneceByCif(cif);
            
            Map<String, Object> estadoConectividad = new HashMap<>();
            int equiposConRed = 0;
            int equiposSinRed = 0;
            
            for (perteneceResponseDTO equipo : equipos) {
                try {
                    redService.getRedActiva(equipo.getIdEquipo());
                    equiposConRed++;
                } catch (Exception e) {
                    equiposSinRed++;
                }
            }
            
            estadoConectividad.put("equipos_con_red", equiposConRed);
            estadoConectividad.put("equipos_sin_red", equiposSinRed);
            estadoConectividad.put("total_equipos", equipos.size());
            estadoConectividad.put("porcentaje_conectados", 
                equipos.size() > 0 ? (equiposConRed * 100.0 / equipos.size()) : 0);
            
            return new ResponseEntity<>(estadoConectividad, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener estado de conectividad");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}