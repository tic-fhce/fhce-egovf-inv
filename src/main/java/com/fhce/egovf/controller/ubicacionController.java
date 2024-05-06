package com.fhce.egovf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.egovf.dao.ubicacionDao;
import com.fhce.egovf.model.ubicacionModel;

@RestController
@RequestMapping("fhce-egovf-inv/ubicacion") //develop
//@RequestMapping("impresora") // produccion
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class ubicacionController {
	
	@Autowired
	private ubicacionDao ubicacionDao;
	
	@PostMapping("/addUbicacion")
	public void addUbicacion(@RequestBody ubicacionModel ubicacionModel) {
		this.ubicacionDao.save(ubicacionModel);
	}
	
	@GetMapping("/getUbicacionCif")
	public List<ubicacionModel>getUbicacionCif(@RequestParam (value="cif") Long cif){
		return(this.ubicacionDao.getUbicacionCif(cif));
	}
	@PutMapping("/updateUbicacion")
	public void updateUbicacion(@RequestBody ubicacionModel ubicacionModel) {
		this.ubicacionDao.save(ubicacionModel);
	}

}
