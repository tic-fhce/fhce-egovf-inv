package com.fhce.egovf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.fhce.egovf.model.impresoraModel;
import com.fhce.egovf.model.monitorModel;
import com.fhce.egovf.model.pcModel;
import com.fhce.egovf.model.telefonoModel;
import com.fhce.egovf.obj.equipoObj;

@RestController
@RequestMapping("fhce-egovf-inv/equipo") //develop
//@RequestMapping("impresora") // produccion
//@CrossOrigin("https://svfhce.umsa.bo/")
@CrossOrigin("http://192.168.31.45:8080/")
public class equipoController {
	
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
	
	@GetMapping("/getListaEquipo")
	public List<equipoObj> getListaEquipo(@RequestParam (value="id") Long id){
		List<String> resumen;
		List<equipoObj>equipoObj = new ArrayList<equipoObj>();
		switch(id.intValue()) {
			case(1):
				List<pcModel>pcModel = this.pcDao.findAll();
				for(int i= 0;i<pcModel.size();i++) {
					resumen = new ArrayList<String>();
					resumen.add("S.O. : "+pcModel.get(i).get_08sistema());
					resumen.add("RAM : "+pcModel.get(i).get_04memorias()+" - "+pcModel.get(i).get_05capacidad());
					resumen.add("MP : "+pcModel.get(i).get_06micro()+" de "+pcModel.get(i).get_07micro_capacidad());
					resumen.add("HHDD : "+pcModel.get(i).get_09disco());
					resumen.add("Detalle : "+pcModel.get(i).get_15detalle());
					equipoObj.add(new equipoObj(pcModel.get(i).getId(),pcModel.get(i).get_01cif(),pcModel.get(i).get_15detalle(),id,pcModel.get(i).get_02codigo(),resumen));
				}
				break;
			case(2):
				List<monitorModel> monitorModel = this.monitorDao.findAll();
				for (int i = 0;i<monitorModel.size();i++) {
					resumen = new ArrayList<String>();
					resumen.add("Marca : "+monitorModel.get(i).get_03marca());
					resumen.add("Pulgadas : "+monitorModel.get(i).get_04pulgadas());
					resumen.add("Tipo : "+monitorModel.get(i).get_05tipo());
					equipoObj.add(new equipoObj(monitorModel.get(i).getId(),monitorModel.get(i).get_01cif(),monitorModel.get(i).get_05tipo(),id,monitorModel.get(i).get_02codigo(),resumen));
				}
				break;
			case(3):
				List<impresoraModel> impresoraModel = this.impresoraDao.findAll();
				for (int i=0;i<impresoraModel.size();i++) {
					resumen = new ArrayList<String>();
					resumen.add("Marca : "+impresoraModel.get(i).get_03marca());
					resumen.add("Modelo : "+impresoraModel.get(i).get_04modelo());
					resumen.add("Detalle : "+impresoraModel.get(i).get_05detalle());
					equipoObj.add(new equipoObj(impresoraModel.get(i).getId(),impresoraModel.get(i).get_01cif(),"Impresora",id,impresoraModel.get(i).get_02codigo(),resumen));
					
				}
				break;
			case(4):
				List<telefonoModel> telefonoModel = this.telefonoDao.findAll();
				for(int i=0;i<telefonoModel.size();i++) {
					resumen = new ArrayList<String>();
					resumen.add("Marca : "+telefonoModel.get(i).get_03marca());
					resumen.add("Ip : "+telefonoModel.get(i).get_04ip());
					resumen.add("Interno : "+telefonoModel.get(i).get_05interno());
					equipoObj.add(new equipoObj(telefonoModel.get(i).getId(),telefonoModel.get(i).get_01cif(),"Telefono",id,telefonoModel.get(i).get_02codigo(),resumen));
				}
				break;
			case(5):
				List<pcModel> internetModel = this.pcDao.findAll();
				for(int i=0;i<internetModel.size();i++) {
					resumen = new ArrayList<String>();
					resumen.add("IP : "+internetModel.get(i).get_10ip());
					resumen.add("Marcara : "+internetModel.get(i).get_12dns());
					resumen.add("Segmento : "+internetModel.get(i).get_13segmento());
					resumen.add("MAC : "+internetModel.get(i).get_11mac());
					resumen.add("Swicht : "+internetModel.get(i).get_16switch());
					resumen.add("Puerto - Vlan : "+internetModel.get(i).get_17puerto()+" - "+internetModel.get(i).get_18vlan());							
					equipoObj.add(new equipoObj(internetModel.get(i).getId(),internetModel.get(i).get_01cif(),"LAN",id,internetModel.get(i).get_02codigo(),resumen));
				}
				break;
		}
		return (equipoObj);
	}

}
