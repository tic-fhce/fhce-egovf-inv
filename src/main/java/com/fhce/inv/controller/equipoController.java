package com.fhce.inv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.inv.obj.equipoDtoResponce;
import com.fhce.inv.service.equipoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fhce-egovf-inv/equipo")
@RequiredArgsConstructor
public class equipoController {
	
	private final equipoService equipoService;
	
	@GetMapping("/getEquipoTipo")
	public ResponseEntity<List<equipoDtoResponce>> getEquipoTipo(@RequestParam (value="id") Long id) {
		try {	
			return new ResponseEntity<>(this.equipoService.getEquipoTipo(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
