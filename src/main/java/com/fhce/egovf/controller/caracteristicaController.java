package com.fhce.egovf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.egovf.dao.caracteristicaDao;
import com.fhce.egovf.model.caracteristicaModel;

@RestController
@RequestMapping("fhce-egovf-inv/caracteristica") //develop
//@RequestMapping("impresora") // produccion
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://172.16.14.91:8080/")
public class caracteristicaController {
	
	@Autowired
	private caracteristicaDao caracterisiticaDao;
	
	@GetMapping("/getCaracteristica")
	public List<caracteristicaModel>getCaracteristica(){
		return(this.caracterisiticaDao.findAll());
	}

}
