package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.asofi.servrest.entity.Proyectos;

public interface ProyectosService {
	
	public Iterable<Proyectos> findAll();
	
	public Page<Proyectos> findAll(Pageable pageable);
	
	public Optional<Proyectos> findByID(Long id);
	
	public Proyectos save(Proyectos proyecto);
	
	public void deteleById(Long id);

}
