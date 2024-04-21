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
@RequestMapping("fhce-egovf-inv/cpu") //develop
//@RequestMapping("pc") // production
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class pcController {
	
	@Autowired
	private pcDao pcDao;
	
	@GetMapping("/listarAll")
	public List<pcModel> listarAll(){
		return(this.pcDao.findAll());
	}
	
	@GetMapping("/getCpuCif")
	public List<pcModel> getCpuCif(@RequestParam (value="cif") Long cif){
		return(this.pcDao.getCpuCif(cif));
	}
	
	@PostMapping("/addCpu")
	public void addCpu(@RequestBody pcModel pcModel) {
		this.pcDao.save(pcModel);
	}
	

}
