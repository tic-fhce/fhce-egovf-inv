package com.fhce.egovf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.egovf.model.atencionModel;
import com.fhce.egovf.model.impresoraModel;

public interface atencionDao extends JpaRepository<atencionModel,Long>{
	
	@Query(value = "select * from atencion where _01cif=?",nativeQuery=true)
	List<atencionModel>getAtencionCif(Long cif);
	
	@Query(value = "select * from atencion where _12estado=0",nativeQuery=true)
	List<atencionModel>getAtencionEspera();

}
