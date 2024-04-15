package com.fhce.egovf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.egovf.model.ubicacionModel;

public interface ubicacionDao extends JpaRepository<ubicacionModel,Long>{
	
	@Query(value = "select * from ubicacion where _01cif=?",nativeQuery=true)
	List<ubicacionModel>getUbicacionCif(Long cif);
}
