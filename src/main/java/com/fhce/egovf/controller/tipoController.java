package com.fhce.egovf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.egovf.dao.tipoDao;
import com.fhce.egovf.model.tipoModel;

@RestController
@RequestMapping("fhce-egovf-inv/tipo") //develop
//@RequestMapping("monitor") //production
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class tipoController {
	
	@Autowired
	private tipoDao tipoDao;
	
	@GetMapping("/getTipo")
	public List<tipoModel>getTipo(){
		return(this.tipoDao.findAll());
	}
}
