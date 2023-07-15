package com.fhce.egovf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.egovf.model.impresoraModel;

public interface impresoraDao extends JpaRepository<impresoraModel,Long>{
	
	@Query(value = "select * from impresora where _01cif=?",nativeQuery=true)
	List<impresoraModel>findImpresora(Long cif);

}
