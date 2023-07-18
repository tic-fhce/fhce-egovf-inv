package com.fhce.egovf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.egovf.dao.telefonoDao;
import com.fhce.egovf.model.telefonoModel;

@RestController
@RequestMapping("fhce-egovf-inv/telefono") //develop
//@RequestMapping("telefono") //production
//@CrossOrigin("urlcliente/")
@CrossOrigin("http://192.168.31.45:8081/")

public class telefonoController {
	
	@Autowired
	private telefonoDao telefonoDao;
	
	@GetMapping("/listarAll")
	public List<telefonoModel> listarAll(){
		return(this.telefonoDao.findAll());
	}
	
	@GetMapping("/listar")
	public List<telefonoModel> listar(@RequestParam (value="cif") Long cif){
		return(this.telefonoDao.findTelefono(cif));
	}
	
	@PostMapping("/agregarTelefono")
	public void agregarTelegono(@RequestBody telefonoModel telefonoModel) {
		this.telefonoDao.save(telefonoModel);
	}
	
	
	
}
