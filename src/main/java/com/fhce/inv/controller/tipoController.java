package com.fhce.inv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.inv.obj.tipoDtoRequest;
import com.fhce.inv.obj.tipoDtoResponce;
import com.fhce.inv.service.tipoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fhce-egovf-inv/tipo")
@RequiredArgsConstructor
public class tipoController {
	
	private final tipoService tipoService;
	
	@GetMapping("/getTipo")
	public ResponseEntity<List<tipoDtoResponce>> getTipo() {
		try {	
			return new ResponseEntity<>(this.tipoService.getTipo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addTipo")
	public ResponseEntity<tipoDtoResponce> addTipo(@RequestBody tipoDtoRequest tipoDtoRequest) {
		try {	
			return new ResponseEntity<>(this.tipoService.addTipo(tipoDtoRequest), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
