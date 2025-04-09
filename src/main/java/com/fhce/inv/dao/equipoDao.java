package com.fhce.inv.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fhce.inv.model.equipoModel;

public interface equipoDao extends JpaRepository<equipoModel, Long>{
	
	@Query(value = "select * from equipo where _04idtipo=?",nativeQuery=true)
	List<equipoModel>getEquipoTipo(Long id);

}
