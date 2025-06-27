package com.fhce.inv.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.inv.obj.ubicacionRequestDTO;
import com.fhce.inv.obj.ubicacionResponseDTO;
import com.fhce.inv.service.ubicacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ubicacion")
@RequiredArgsConstructor
public class ubicacionController {

    private final ubicacionService ubicacionService;
    
    @PostMapping("/add")
    public ResponseEntity<?> addUbicacion(@RequestBody ubicacionRequestDTO ubicacionRequestDTO) {
        try {
            ubicacionResponseDTO response = ubicacionService.addUbicacion(ubicacionRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updateUbicacion(
            @RequestParam Long id,
            @RequestBody ubicacionRequestDTO ubicacionRequestDTO) {
        try {
            ubicacionResponseDTO response = ubicacionService.updateUbicacion(id, ubicacionRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porIdUbicacion")
    public ResponseEntity<?> getUbicacion(@RequestParam Long id) {
        try {
            ubicacionResponseDTO response = ubicacionService.getUbicacion(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porEquipo")
    public ResponseEntity<?> getUbicacionesPorEquipo(@RequestParam Long idEquipo) {
        try {
            List<ubicacionResponseDTO> response = ubicacionService.getUbicacionesPorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/activa")
    public ResponseEntity<?> getUbicacionActiva(@RequestParam Long idEquipo) {
        try {
            ubicacionResponseDTO response = ubicacionService.getUbicacionActiva(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/historial")
    public ResponseEntity<?> getHistorialUbicaciones(@RequestParam Long idEquipo) {
        try {
            List<ubicacionResponseDTO> response = ubicacionService.getHistorialUbicaciones(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cambiarEstado")
    public ResponseEntity<?> cambiarEstadoUbicacion(
            @RequestParam Long id,
            @RequestParam int estado) {
        try {
            ubicacionResponseDTO response = ubicacionService.cambiarEstadoUbicacion(id, estado);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}