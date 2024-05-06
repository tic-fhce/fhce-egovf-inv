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

import com.fhce.egovf.dao.monitorDao;
import com.fhce.egovf.dao.perteneceDao;
import com.fhce.egovf.model.monitorModel;
import com.fhce.egovf.model.perteneceModel;
import com.fhce.egovf.obj.monitorObj;

@RestController
@RequestMapping("fhce-egovf-inv/monitor") //develop
//@RequestMapping("monitor") //production
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class monitorController {
	
	@Autowired
	private monitorDao monitorDao;
	
	@Autowired
	private perteneceDao perteneceDao;
	
	@GetMapping("/listarAll")
	public List<monitorModel>listarAll(){
		return(this.monitorDao.findAll());
	}
	
	@GetMapping("/getMonitorCif")
	public List<monitorObj>getMonitorCif(@RequestParam (value="cif") Long cif){
		
		List<monitorModel>monitorModel = this.monitorDao.getMonitorCif(cif);
		List<perteneceModel>perteneceModel = this.perteneceDao.getPerteneceCif(cif);
		List<monitorObj>monitorObj = new ArrayList<monitorObj>();
		monitorModel moAux ;
		perteneceModel pmAux;
		for(int i=0;i<monitorModel.size();i++) {
			moAux = monitorModel.get(i); 
			for(int j = i;j<perteneceModel.size();j++) {
				pmAux = perteneceModel.get(j);
				if(moAux.get_01cif().longValue() == pmAux.get_01cif() && moAux.get_02codigo().equals(pmAux.get_02codigo())) {
					monitorObj.add(new monitorObj(moAux.getId(), moAux.get_01cif(), moAux.get_02codigo(), moAux.get_03marca(), moAux.get_04pulgadas(), moAux.get_05tipo(), moAux.get_06idubicacion(),pmAux.getId(), pmAux.get_03fecha_add(), pmAux.get_04fecha_del(), pmAux.get_05estado()));
				}
			}
		}
		return(monitorObj);
	}
	
	@PostMapping("/addMonitor")
	public void addMonitor(@RequestBody monitorModel monitorModel) {
		
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
		
		perteneceModel.set_01cif(monitorModel.get_01cif());
		perteneceModel.set_02codigo(monitorModel.get_02codigo());
		perteneceModel.set_03fecha_add(date.getYear()+"-"+mes+"-"+dia);
		perteneceModel.set_04fecha_del("Activo");
		perteneceModel.set_05estado(1);
		perteneceModel.set_06idtipo((long)2);
		
		this.perteneceDao.save(perteneceModel);
		this.monitorDao.save(monitorModel);
	}
	
	@PutMapping("/updateMonitor")
	public void updateMonitor(@RequestBody monitorModel monitorModel) {
		this.monitorDao.save(monitorModel);
	}

}
