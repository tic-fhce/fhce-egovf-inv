package com.fhce.inv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.inv.obj.equipoResponseDTO;
import com.fhce.inv.obj.tipoRequestDTO;
import com.fhce.inv.obj.tipoResponseDTO;
import com.fhce.inv.service.tipoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tipo")
@RequiredArgsConstructor
public class tipoController {

    private final tipoService tipoService;
    
    @PostMapping("/add")
    public ResponseEntity<tipoResponseDTO> addTipo(@RequestBody tipoRequestDTO tipoRequestDTO) {
        try {
            tipoResponseDTO response = tipoService.addTipo(tipoRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get")
    public ResponseEntity<tipoResponseDTO> getTipo(@RequestParam Long id) {
        try {
            tipoResponseDTO response = tipoService.getTipo(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/equipos")
    public ResponseEntity<List<equipoResponseDTO>> getEquiposPorTipo(@RequestParam Long idTipo) {
        try {
            List<equipoResponseDTO> response = tipoService.getEquiposPorTipo(idTipo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}