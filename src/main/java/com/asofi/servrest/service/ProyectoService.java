package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.asofi.servrest.entity.Proyecto;

public interface ProyectoService {
	
	public Iterable<Proyecto> findAll();
	
	public Page<Proyecto> findAll(Pageable pageable);
	
	public Optional<Proyecto> findByID(Long id);
	
	public Proyecto save(Proyecto proyecto);
	
	public void deteleById(Long id);
	
	public Optional<Proyecto> findByIDEmpresa(Long id);

}
