package com.asofi.servrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asofi.servrest.entity.Proyectos;
import com.asofi.servrest.entity.Riesgos;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Long>{
	
	

}
