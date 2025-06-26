package com.fhce.inv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fhce.inv.obj.atencionRequestDTO;
import com.fhce.inv.obj.atencionResponseDTO;
import com.fhce.inv.service.atencionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/atencion")
@RequiredArgsConstructor
public class atencionController {

    private final atencionService atencionService;
    
    @PostMapping("/addAtencion")
    public ResponseEntity<?> crearAtencion(@RequestBody atencionRequestDTO request) {
        try {
            atencionResponseDTO response = atencionService.crearAtencion(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al crear atención");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> actualizarAtencion(
            @RequestParam Long idAtencion,
            @RequestBody atencionRequestDTO request) {
        try {
            atencionResponseDTO response = atencionService.actualizarAtencion(idAtencion, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al actualizar atención");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/get")
    public ResponseEntity<?> getAtencion(@RequestParam Long idAtencion) {
        try {
            atencionResponseDTO response = atencionService.getAtencion(idAtencion);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Atención no encontrada");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/porSolicitud")
    public ResponseEntity<?> getAtencionesPorSolicitud(@RequestParam Long idSolicitud) {
        try {
            List<atencionResponseDTO> response = atencionService.getAtencionesPorSolicitud(idSolicitud);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener atenciones de la solicitud");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/porEquipo")
    public ResponseEntity<?> getAtencionesPorEquipo(@RequestParam Long idEquipo) {
        try {
            List<atencionResponseDTO> response = atencionService.getAtencionesPorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener atenciones del equipo");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/todas")
    public ResponseEntity<?> getTodasLasAtenciones() {
        try {
            List<atencionResponseDTO> response = atencionService.getTodasLasAtenciones();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener todas las atenciones");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porCif")
    public ResponseEntity<?> getAtencionesPorCif(@RequestParam Long cif) {
        try {
            List<atencionResponseDTO> response = atencionService.getAtencionesPorCif(cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener atenciones del CIF");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}