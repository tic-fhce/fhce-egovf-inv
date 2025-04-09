package com.fhce.inv.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.inv.model.atencionModel;

public interface atencionDao extends JpaRepository<atencionModel, Long>{
	
	@Query(value = "select * from atencion where _09estado=0",nativeQuery=true)
	List<atencionModel>getAtencionEspera();

}
