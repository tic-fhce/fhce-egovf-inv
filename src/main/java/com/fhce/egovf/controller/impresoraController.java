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

import com.fhce.egovf.dao.impresoraDao;
import com.fhce.egovf.dao.perteneceDao;
import com.fhce.egovf.model.impresoraModel;
import com.fhce.egovf.model.perteneceModel;
import com.fhce.egovf.obj.impresoraObj;

@RestController
@RequestMapping("fhce-egovf-inv/impresora") //develop
//@RequestMapping("impresora") // produccion
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://172.16.14.91:8080/")
public class impresoraController {
	
	@Autowired
	private impresoraDao impresoraDao;
	
	@Autowired
	private perteneceDao perteneceDao;
	
	@GetMapping("/listarAll")
	public List<impresoraModel> listarAll(){
		return this.impresoraDao.findAll();
	}
	
	@GetMapping("/getImpresoraCif")
	public List<impresoraObj>getImpresoraCif(@RequestParam (value="cif") Long cif){
		
		List<impresoraModel>impresoraModel = this.impresoraDao.getImpresoraCif(cif);
		List<perteneceModel>perteneceModel = this.perteneceDao.getPerteneceCif(cif);
		List<impresoraObj>impresoraObj = new ArrayList<impresoraObj>();
		impresoraModel imAux ;
		perteneceModel pmAux;
		for(int i=0;i<impresoraModel.size();i++) {
			imAux = impresoraModel.get(i); 
			for(int j = i;j<perteneceModel.size();j++) {
				pmAux = perteneceModel.get(j);
				if(imAux.get_01cif().longValue() == pmAux.get_01cif() && imAux.get_02codigo().equals(pmAux.get_02codigo())) {
					impresoraObj.add(new impresoraObj(imAux.getId(),imAux.get_01cif(),imAux.get_02codigo(),imAux.get_03marca(),imAux.get_04modelo(),imAux.get_05detalle(),imAux.get_06idubicacion(),pmAux.getId(),pmAux.get_03fecha_add(),pmAux.get_04fecha_del(),pmAux.get_05estado()));
				}
			}
		}
		return(impresoraObj);
	}
	
	@PostMapping("/addImpresora")
	public void addImpresora(@RequestBody impresoraModel impresoraModel) {
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
		
		perteneceModel.set_01cif(impresoraModel.get_01cif());
		perteneceModel.set_02codigo(impresoraModel.get_02codigo());
		perteneceModel.set_03fecha_add(date.getYear()+"-"+mes+"-"+dia);
		perteneceModel.set_04fecha_del("Activo");
		perteneceModel.set_05estado(1);
		perteneceModel.set_06idtipo((long)3);
		
		this.perteneceDao.save(perteneceModel);
		this.impresoraDao.save(impresoraModel);
	}
	@PutMapping("/updateImpresora")
	public void updateImpresora(@RequestBody impresoraModel impresoraModel) {
		this.impresoraDao.save(impresoraModel);
	}
}
