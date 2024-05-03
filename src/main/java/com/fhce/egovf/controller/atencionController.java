package com.fhce.egovf.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhce.egovf.dao.atencionDao;
import com.fhce.egovf.dao.caracteristicaDao;
import com.fhce.egovf.dao.impresoraDao;
import com.fhce.egovf.dao.monitorDao;
import com.fhce.egovf.dao.pcDao;
import com.fhce.egovf.dao.telefonoDao;
import com.fhce.egovf.dao.tipoDao;
import com.fhce.egovf.model.atencionModel;
import com.fhce.egovf.model.caracteristicaModel;
import com.fhce.egovf.model.impresoraModel;
import com.fhce.egovf.model.monitorModel;
import com.fhce.egovf.model.pcModel;
import com.fhce.egovf.model.telefonoModel;
import com.fhce.egovf.model.tipoModel;
import com.fhce.egovf.obj.atencionObj;

@RestController
@RequestMapping("fhce-egovf-inv/atencion") //develop
//@RequestMapping("impresora") // produccion
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://172.16.14.91:8080/")
public class atencionController {
	
	@Autowired
	private atencionDao atencionDao;
	
	@Autowired
	private tipoDao tipoDao;
	
	@Autowired
	private caracteristicaDao caractersiticaDao;
	
	@Autowired
	private pcDao pcDao;
	
	@Autowired
	private monitorDao monitorDao;
	
	@Autowired
	private impresoraDao impresoraDao;
	
	@Autowired
	private telefonoDao telefonoDao;
	
	@PostMapping("/addAtencion")
	public void addAtencion(@RequestBody atencionModel atencionModel) {
		
		LocalDate date = LocalDate.now();
		LocalDateTime hora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		int m = date.getMonthValue();
		int d = date.getDayOfMonth();
		String mes = ""+m;
		String dia = ""+d;
		if(m<10)
			mes = "0"+m;
		if(d<10)
			dia = "0"+d;
		
		atencionModel.set_03fechasolicitud(date.getYear()+"-"+mes+"-"+dia);
		atencionModel.set_04horasolicitud(hora.format(formatter));
		atencionModel.set_12estado(0);
		
		this.atencionDao.save(atencionModel);
	}
	
	@GetMapping("/getAtencionCif")
	public List<atencionObj>getAtencionCif(@RequestParam (value="cif") Long cif){
		
		List<atencionModel> atencionModel = this.atencionDao.getAtencionCif(cif);
		List<tipoModel> tipoModel = this.tipoDao.findAll();
		List<caracteristicaModel> caracteristicaModel = this.caractersiticaDao.findAll();
		List<atencionObj> atencionObj = new ArrayList<atencionObj>();
		String resumen = "";
		String equipo = "";
		String caracteristica = "";
		for(int i=0;i<atencionModel.size();i++) {
			
			int c = atencionModel.get(i).get_05idtipo().intValue(); 
			switch(c) {
				case(1):
					List<pcModel> pcModel =  this.pcDao.getCpuCif(cif);
					for (int j =0;j<pcModel.size();j++) {
						if(atencionModel.get(i).get_02codigo().equals(pcModel.get(j).get_02codigo())) {
							resumen = pcModel.get(j).get_08sistema()+"<br>"+pcModel.get(i).get_04memorias()+" - "+pcModel.get(i).get_05capacidad()+"<br>"+pcModel.get(i).get_06micro()+" de "+pcModel.get(i).get_07micro_capacidad()+"<br>"+pcModel.get(i).get_09disco()+"<br>"+pcModel.get(i).get_15detalle()+"<br>"+pcModel.get(i).get_03fuente()+"<br>"+pcModel.get(i).get_14cortapico();
						}
					}
					break;
				case(2):
					List<monitorModel> monitorModel = this.monitorDao.getMonitorCif(cif);
					for (int j = 0;j<monitorModel.size();j++) {
						if(atencionModel.get(i).get_02codigo().equals(monitorModel.get(j).get_02codigo())) {
							resumen = monitorModel.get(j).get_03marca()+"<br>"+monitorModel.get(j).get_04pulgadas()+"<br>"+monitorModel.get(j).get_05tipo();
						}
					}
					break;
				case(3):
					List<impresoraModel> impresoraModel = this.impresoraDao.getImpresoraCif(cif);
					for (int j=0;j<impresoraModel.size();j++) {
						if(atencionModel.get(i).get_02codigo().equals(impresoraModel.get(j).get_02codigo())) {
							resumen = impresoraModel.get(j).get_03marca()+"<br>"+impresoraModel.get(j).get_04modelo()+"<br>"+impresoraModel.get(j).get_05detalle();
						}
					}
					break;
				case(4):
					List<telefonoModel> telefonoModel = this.telefonoDao.getTelefonoCif(cif);
					for(int j=0;j<telefonoModel.size();j++) {
						if(atencionModel.get(i).get_02codigo().equals(telefonoModel.get(j).get_02codigo())) {
							resumen = telefonoModel.get(j).get_03marca()+"<br>"+telefonoModel.get(j).get_04ip()+"<br>"+telefonoModel.get(j).get_05interno();
						}
					}
					break;
				case(5):
					List<pcModel> internetModel = this.pcDao.getCpuCif(cif);
					for(int j=0;j<internetModel.size();j++) {
						if(atencionModel.get(i).get_02codigo().equals(internetModel.get(j).get_02codigo())) {
							resumen = internetModel.get(j).get_10ip()+"<br>"+internetModel.get(j).get_12dns()+"<br>"+internetModel.get(j).get_13segmento()+"<br>"+internetModel.get(j).get_11mac()+"<br>"+internetModel.get(j).get_16switch()+"-"+internetModel.get(j).get_17puerto()+" - "+internetModel.get(j).get_18vlan();
						}
					}
					break;
			}
			for(int k=0;k<tipoModel.size();k++) {
				if(tipoModel.get(k).getId().longValue() == atencionModel.get(i).get_05idtipo().longValue()) {
					equipo = tipoModel.get(k).get_01sigla();
				}
			}
			for(int k=0;k<caracteristicaModel.size();k++) {
				if(caracteristicaModel.get(k).getId().longValue() == atencionModel.get(i).get_06idcaracteristica().longValue()) {
					caracteristica = caracteristicaModel.get(k).get_02detalle();
				}
			}
			atencionObj at = new atencionObj(atencionModel.get(i).getId(), atencionModel.get(i).get_01cif(), atencionModel.get(i).get_02codigo(), atencionModel.get(i).get_03fechasolicitud(), atencionModel.get(i).get_04horasolicitud(), equipo,
					resumen, caracteristica, atencionModel.get(i).get_07especificacion(), atencionModel.get(i).get_08error(), atencionModel.get(i).get_09detalle(),
					atencionModel.get(i).get_10fechaatencion(), atencionModel.get(i).get_11horaatencion() ,atencionModel.get(i).get_12estado());
			
			atencionObj.add(at);
		}
		return(atencionObj);
	}

}
