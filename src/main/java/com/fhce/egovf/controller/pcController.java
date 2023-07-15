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

import com.fhce.egovf.dao.pcDao;
import com.fhce.egovf.model.pcModel;

@RestController
//@RequestMapping("fhce-egovf-inv/pc") //develop
@RequestMapping("pc") // production
@CrossOrigin("urlcliente/")
//@CrossOrigin("http://192.168.31.45:8081/")
public class pcController {
	
	@Autowired
	private pcDao pcDao;
	
	@GetMapping("/listarAll")
	public List<pcModel> listarAll(){
		return(this.pcDao.findAll());
	}
	
	@GetMapping("/listar")
	public List<pcModel> listar(@RequestParam (value="cif") Long cif){
		return(this.pcDao.findPc(cif));
	}
	
	@PostMapping("/agregarPc")
	public void agregarPC(@RequestBody pcModel pcModel) {
		this.pcDao.save(pcModel);
	}
	

}
