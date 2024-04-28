package com.fhce.egovf.controller;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.fhce.egovf.dao.perteneceDao;
import com.fhce.egovf.dao.telefonoDao;
import com.fhce.egovf.model.perteneceModel;
import com.fhce.egovf.model.telefonoModel;
import com.fhce.egovf.obj.telefonoObj;

@RestController
@RequestMapping("fhce-egovf-inv/telefono") //develop
//@RequestMapping("telefono") //production
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")

public class telefonoController {
	
	@Autowired
	private telefonoDao telefonoDao;
	
	@Autowired
	private perteneceDao perteneceDao;
	
	@GetMapping("/listarAll")
	public List<telefonoModel> listarAll(){
		return(this.telefonoDao.findAll());
	}
	
	@GetMapping("/getTelefonoCif")
	public List<telefonoObj> listar(@RequestParam (value="cif") Long cif){
		
		List<telefonoModel>telefonoModel = this.telefonoDao.getTelefonoCif(cif);
		List<perteneceModel>perteneceModel = this.perteneceDao.getPerteneceCif(cif);
		List<telefonoObj>telefonoObj = new ArrayList<telefonoObj>();
		telefonoModel telAux ;
		perteneceModel pmAux;
		for(int i=0;i<telefonoModel.size();i++) {
			telAux = telefonoModel.get(i); 
			for(int j = i;j<perteneceModel.size();j++) {
				pmAux = perteneceModel.get(j);
				if(telAux.get_01cif().longValue() == pmAux.get_01cif() && telAux.get_02codigo().equals(pmAux.get_02codigo())) {
					telefonoObj.add(new telefonoObj(telAux.getId(), telAux.get_01cif(), telAux.get_02codigo(), telAux.get_03marca(), telAux.get_04ip(), telAux.get_05interno(),telAux.get_06idubicacion(), pmAux.getId(), pmAux.get_03fecha_add(), pmAux.get_04fecha_del(), pmAux.get_05estado()));
				}
			}
		}
		
		return(telefonoObj);
	}
	
	@PostMapping("/addTelefono")
	public void addTelegono(@RequestBody telefonoModel telefonoModel) {
		perteneceModel perteneceModel = new perteneceModel();
		LocalDate date = LocalDate.now();
		int m = date.getMonthValue();
		int d = date.getDayOfMonth();
		String mes = ""+m;
		String dia = ""+d;
		if(m<10)
			mes = "0"+m;
		if(d<10)
			dia = "0"+d;
		
		perteneceModel.set_01cif(telefonoModel.get_01cif());
		perteneceModel.set_02codigo(telefonoModel.get_02codigo());
		perteneceModel.set_03fecha_add(date.getYear()+"-"+mes+"-"+dia);
		perteneceModel.set_04fecha_del("Activo");
		perteneceModel.set_05estado(1);
		
		this.perteneceDao.save(perteneceModel);
		this.telefonoDao.save(telefonoModel);
	}
	
	@PutMapping("/updateTelefono")
	public void updateTelegono(@RequestBody telefonoModel telefonoModel) {
		this.telefonoDao.save(telefonoModel);
	}
	
}
