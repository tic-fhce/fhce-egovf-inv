package com.fhce.egovf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.egovf.dao.atencionDao;

@RestController
@RequestMapping("fhce-egovf-inv/atencion") //develop
//@RequestMapping("impresora") // produccion
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class atencionController {
	
	@Autowired
	private atencionDao atencionDao;

}
