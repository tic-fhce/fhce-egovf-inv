package com.fhce.egovf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.egovf.model.perteneceModel;

public interface perteneceDao extends JpaRepository<perteneceModel,Long>{

	@Query(value = "select * from pertenece where _01cif=?",nativeQuery=true)
	List<perteneceModel>getPerteneceCif(Long cif);
}
