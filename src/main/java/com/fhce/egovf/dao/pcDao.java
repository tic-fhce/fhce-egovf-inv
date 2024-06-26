package com.fhce.egovf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.egovf.model.pcModel;

public interface pcDao extends JpaRepository<pcModel,Long> {
	
	@Query(value = "select * from pc where _01cif=?",nativeQuery=true)
	List<pcModel>getCpuCif(Long cif);
	
	@Query(value = "select * from pc where _02codigo=?",nativeQuery=true)
	List<pcModel>getCpu(String codigo);
}
