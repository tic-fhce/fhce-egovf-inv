package com.fhce.inv.service;

import java.util.List;

import com.fhce.inv.obj.tipoDtoRequest;
import com.fhce.inv.obj.tipoDtoResponce;

public interface tipoService {
	List<tipoDtoResponce>getTipo();
	tipoDtoResponce addTipo(tipoDtoRequest tipoDtoRequest);

}
