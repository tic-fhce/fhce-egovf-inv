package com.fhce.inv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.inv.obj.perteneceRequestDTO;
import com.fhce.inv.obj.perteneceResponseDTO;
import com.fhce.inv.service.perteneceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pertenece")
@RequiredArgsConstructor
public class perteneceController {

    private final perteneceService perteneceService;
    
    @PostMapping("/add")
    public ResponseEntity<perteneceResponseDTO> addPertenece(@RequestBody perteneceRequestDTO perteneceRequestDTO) {
        try {
            perteneceResponseDTO response = perteneceService.addPertenece(perteneceRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<perteneceResponseDTO> updatePertenece(
            @RequestParam Long id,
            @RequestBody perteneceRequestDTO perteneceRequestDTO) {
        try {
            perteneceResponseDTO response = perteneceService.updatePertenece(id, perteneceRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/updatePorEquipo")
    public ResponseEntity<?> updatePerteneceByEquipo(
            @RequestParam Long idEquipo,
            @RequestBody perteneceRequestDTO perteneceRequestDTO) {
        try {
            perteneceResponseDTO response = perteneceService.updatePerteneceIdEquipo(idEquipo, perteneceRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error al actualizar asignación por equipo");
            errorResponse.put("error", e.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get")
    public ResponseEntity<perteneceResponseDTO> getPertenece(@RequestParam Long id) {
        try {
            perteneceResponseDTO response = perteneceService.getPertenece(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porCif")
    public ResponseEntity<List<perteneceResponseDTO>> getPerteneceByCif(@RequestParam Long cif) {
        try {
            List<perteneceResponseDTO> response = perteneceService.getPerteneceByCif(cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porEquipo")
    public ResponseEntity<List<perteneceResponseDTO>> getPertenecePorEquipo(@RequestParam Long idEquipo) {
        try {
            List<perteneceResponseDTO> response = perteneceService.getPertenecePorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/porEquipoYCif")
    public ResponseEntity<?> getPertenecePorEquipoYCif(
            @RequestParam Long idEquipo,
            @RequestParam Long cif) {
        try {
            List<perteneceResponseDTO> response = perteneceService.getPertenecePorEquipoYCif(idEquipo, cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/equiposPorTipo")
    public ResponseEntity<?> getEquiposPorTipo(@RequestParam Long idTipo) {
        try {
            List<perteneceResponseDTO> response = perteneceService.getEquiposPorTipo(idTipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/historial/equipo")
    public ResponseEntity<?> getHistorialPorEquipo(@RequestParam Long idEquipo) {
        try {
            List<perteneceResponseDTO> response = perteneceService.getHistorialPorEquipo(idEquipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener historial del equipo");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/historial/cif")
    public ResponseEntity<?> getHistorialPorCif(@RequestParam Long cif) {
        try {
            List<perteneceResponseDTO> response = perteneceService.getHistorialPorCif(cif);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Error al obtener historial del CIF");
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}