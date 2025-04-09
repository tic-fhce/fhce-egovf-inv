package com.fhce.inv.service;

import java.util.List;

import com.fhce.inv.obj.atencionDtoRequest;
import com.fhce.inv.obj.atencionDtoResponce;

public interface atencionService {
	atencionDtoResponce addAtencion(atencionDtoRequest atencionDtoRequest);
	atencionDtoResponce updateAtencion(atencionDtoResponce atencionDtoResponce);
	List<atencionDtoResponce> getListaEspera();

}
