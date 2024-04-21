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
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class monitorController {
	
	@Autowired
	private monitorDao monitorDao;
	
	@GetMapping("/listarAll")
	public List<monitorModel>listarAll(){
		return(this.monitorDao.findAll());
	}
	
	@GetMapping("/getMonitorCif")
	public List<monitorModel>getMonitorCif(@RequestParam (value="cif") Long cif){
		return(this.monitorDao.getMonitorCif(cif));
	}
	
	@PostMapping("/addMonitor")
	public void addMonitor(@RequestBody monitorModel monitorModel) {
		this.monitorDao.save(monitorModel);
	}

}
