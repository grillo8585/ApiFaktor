package com.asofi.servrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asofi.servrest.entity.Proyecto;
import com.asofi.servrest.entity.Riesgo;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyecto, Long>{
	
	

}
