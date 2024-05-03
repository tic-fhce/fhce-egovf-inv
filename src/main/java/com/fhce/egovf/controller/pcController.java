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

import com.fhce.egovf.dao.pcDao;
import com.fhce.egovf.dao.perteneceDao;
import com.fhce.egovf.model.pcModel;
import com.fhce.egovf.model.perteneceModel;
import com.fhce.egovf.obj.pcObj;

@RestController
@RequestMapping("fhce-egovf-inv/cpu") //develop
//@RequestMapping("pc") // production
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://172.16.14.91:8080/")
public class pcController {
	
	@Autowired
	private pcDao pcDao;
	
	@Autowired
	private perteneceDao perteneceDao;
	
	@GetMapping("/listarAll")
	public List<pcModel> listarAll(){
		return(this.pcDao.findAll());
	}
	
	@GetMapping("/getCpuCif")
	public List<pcObj> getCpuCif(@RequestParam (value="cif") Long cif){
		
		List<pcModel>pcModel = this.pcDao.getCpuCif(cif);
		List<perteneceModel>perteneceModel = this.perteneceDao.getPerteneceCif(cif);
		List<pcObj>pcObj = new ArrayList<pcObj>();
		pcModel pcAux ;
		perteneceModel pmAux;
		for(int i=0;i<pcModel.size();i++) {
			pcAux = pcModel.get(i); 
			for(int j = i;j<perteneceModel.size();j++) {
				pmAux = perteneceModel.get(j);
				if(pcAux.get_01cif().longValue() == pmAux.get_01cif() && pcAux.get_02codigo().equals(pmAux.get_02codigo())) {
					pcObj.add(new pcObj(pcAux.getId(), pcAux.get_01cif(), pcAux.get_02codigo(), pcAux.get_03fuente(), pcAux.get_04memorias(), pcAux.get_05capacidad(), pcAux.get_06micro(),
							pcAux.get_07micro_capacidad(), pcAux.get_08sistema(), pcAux.get_09disco(), pcAux.get_10ip(), pcAux.get_11mac(), pcAux.get_12dns(),pcAux.get_13segmento(),
							pcAux.get_14cortapico(), pcAux.get_15detalle(), pcAux.get_16switch(), pcAux.get_17puerto(), pcAux.get_18vlan(), pcAux.get_19idubicacion(),
							pmAux.getId(), pmAux.get_03fecha_add(), pmAux.get_04fecha_del(), pmAux.get_05estado()));
				}
			}
		}
		return(pcObj);
	}
	
	@PostMapping("/addCpu")
	public void addCpu(@RequestBody pcModel pcModel) throws Exception{
		
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
		
		perteneceModel.set_01cif(pcModel.get_01cif());
		perteneceModel.set_02codigo(pcModel.get_02codigo());
		perteneceModel.set_03fecha_add(date.getYear()+"-"+mes+"-"+dia);
		perteneceModel.set_04fecha_del("Activo");
		perteneceModel.set_05estado(1);
		perteneceModel.set_06idtipo((long)1);
		
		this.perteneceDao.save(perteneceModel);
		this.pcDao.save(pcModel);
	}
	
	@PutMapping("/updateCpu")
	public void updateCpu(@RequestBody pcModel pcModel) throws Exception{
		this.pcDao.save(pcModel);
	}
	
}
