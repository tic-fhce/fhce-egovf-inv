package com.fhce.egovf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.egovf.dao.perteneceDao;
import com.fhce.egovf.model.perteneceModel;

@RestController
@RequestMapping("fhce-egovf-inv/pertenece") //develop
//@RequestMapping("monitor") //production
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class perteneceController {
	
	@Autowired
	private perteneceDao perteneceDao;
	
	@GetMapping("/getPerteneceCif")
	public List<perteneceModel>getPerteneceCif(@RequestParam (value="cif") Long cif){
		return(this.perteneceDao.getPerteneceCif(cif));
	}

}
