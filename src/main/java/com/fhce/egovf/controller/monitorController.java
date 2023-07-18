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

import com.fhce.egovf.dao.monitorDao;
import com.fhce.egovf.model.monitorModel;

@RestController
@RequestMapping("fhce-egovf-inv/monitor") //develop
//@RequestMapping("monitor") //production
//@CrossOrigin("urlcliente/")
@CrossOrigin("http://192.168.31.45:8081/")
public class monitorController {
	
	@Autowired
	private monitorDao monitorDao;
	
	@GetMapping("/listarAll")
	public List<monitorModel>listarAll(){
		return(this.monitorDao.findAll());
	}
	
	@GetMapping("/listar")
	public List<monitorModel>listar(@RequestParam (value="cif") Long cif){
		return(this.monitorDao.findMonitor(cif));
	}
	
	@PostMapping("/agregarMonitor")
	public void agregarMonitor(@RequestBody monitorModel monitorModel) {
		this.monitorDao.save(monitorModel);
	}

}
