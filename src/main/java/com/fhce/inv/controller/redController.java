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

import com.fhce.inv.obj.redRequestDTO;
import com.fhce.inv.obj.redResponseDTO;
import com.fhce.inv.service.redService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/red")
@RequiredArgsConstructor
public class redController {

    private final redService redService;
    
    @PostMapping("/add")
    public ResponseEntity<?> addRed(@RequestBody redRequestDTO redRequestDTO) {
        try {
            redResponseDTO response = redService.addRed(redRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updateRed(
            @RequestParam Long id,
            @RequestBody redRequestDTO redRequestDTO) {
        try {
            redResponseDTO response = redService.updateRed(id, redRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porIdRed")
    public ResponseEntity<?> getRed(@RequestParam Long id) {
        try {
            redResponseDTO response = redService.getRed(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porEquipo")
    public ResponseEntity<?> getRedPorEquipo(@RequestParam Long idEquipo) {
        try {
            List<redResponseDTO> response = redService.getRedPorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/cambiarEstado")
    public ResponseEntity<?> cambiarEstadoRed(
            @RequestParam Long id,
            @RequestParam int estado) {
        try {
            redResponseDTO response = redService.cambiarEstadoRed(id, estado);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/activa")
    public ResponseEntity<?> getRedActiva(@RequestParam Long idEquipo) {
        try {
            redResponseDTO response = redService.getRedActiva(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/historial")
    public ResponseEntity<?> getHistorialRedes(@RequestParam Long idEquipo) {
        try {
            List<redResponseDTO> response = redService.getHistorialRedes(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
