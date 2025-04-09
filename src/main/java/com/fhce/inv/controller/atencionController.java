package com.fhce.inv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.inv.obj.atencionDtoRequest;
import com.fhce.inv.obj.atencionDtoResponce;
import com.fhce.inv.service.atencionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fhce-egovf-inv/atencion")
@RequiredArgsConstructor
public class atencionController {
	
	private final atencionService atencionService;
	
	@PostMapping("/addAtencion")
	public ResponseEntity<atencionDtoResponce> addAtencion(@RequestBody atencionDtoRequest atencionDtoRequest) {
		
		try {
			return new ResponseEntity<>(this.atencionService.addAtencion(atencionDtoRequest),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getListaEspera")
	public ResponseEntity<List<atencionDtoResponce>> getListaEspera(@RequestParam Long cif) {
		try {
	      return new ResponseEntity<>(this.atencionService.getListaEspera(), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping("/updateAtencion")
	public ResponseEntity<atencionDtoResponce> updateAtencion(@RequestBody atencionDtoResponce atencionDtoResponce) {
		try {	
			return new ResponseEntity<>(this.atencionService.updateAtencion(atencionDtoResponce), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

}
