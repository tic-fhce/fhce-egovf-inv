package com.fhce.egovf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.egovf.model.telefonoModel;

public interface telefonoDao extends JpaRepository<telefonoModel,Long>{
	
	@Query(value = "select * from telefono where _01cif=?",nativeQuery=true)
	List<telefonoModel>getTelefonoCif(Long cif);

}
