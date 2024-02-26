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

import com.fhce.egovf.dao.impresoraDao;
import com.fhce.egovf.model.impresoraModel;

@RestController
@RequestMapping("fhce-egovf-inv/impresora") //develop
//@RequestMapping("impresora") // produccion
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class impresoraController {
	
	@Autowired
	private impresoraDao impresoraDao;
	
	@GetMapping("/listarAll")
	public List<impresoraModel> listarAll(){
		return this.impresoraDao.findAll();
	}
	
	@GetMapping("/listar")
	public List<impresoraModel>listar(@RequestParam (value="cif") Long cif){
		return(this.impresoraDao.findImpresora(cif));
	}
	
	@PostMapping("/agregarImpresora")
	public void agregarImpresora(@RequestBody impresoraModel impresoraModel) {
		this.impresoraDao.save(impresoraModel);
	}
}
