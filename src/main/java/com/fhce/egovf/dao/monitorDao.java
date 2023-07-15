package com.fhce.egovf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.egovf.model.monitorModel;

public interface monitorDao extends JpaRepository<monitorModel,Long>{
	
	@Query(value = "select * from monitor where _01cif=?",nativeQuery=true)
	List<monitorModel>findMonitor(Long cif);

}
